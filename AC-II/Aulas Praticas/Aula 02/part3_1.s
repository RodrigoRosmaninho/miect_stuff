    .equ READ_CORE_TIMER,11
    .equ RESET_CORE_TIMER,12
    .equ PUT_CHAR,3
    .equ PRINT_INT,6 
    .data
    .text
    .globl main

######## MAIN ########
# Mapa de Registos
# $s2 : switches

main: 
    addi $sp,$sp,-4         #
    sw $ra, 0($sp)          #

while:
    li $a0, 2000            #
    jal delay               # delay(2000);
    lui $s1,0xBF88          #
    lw $s2,0x6050($s1)      # getSwitches
    
    li $a0,' '              #
    li $v0,PUT_CHAR         #
    syscall                 # putChar(' ');
    li $t0, 0xFFF0          # 
    sub $s2,$s2,$t0         # switches -= 0xFFF0
    move $a0,$s2            #
    li $a1,2                #
    li $v0,PRINT_INT        #
    syscall                 # printInt(switches, 2);
    b while                 # }
    
endw:
    lw $ra, 0($sp)          #
    addi $sp,$sp,4          #
    jr $ra                  # return;

######## DELAY ########
# Mapa de Registos
# $t0 : ms

delay: 
    move $t0, $a0           # ms = arg[0]

for:
    li $v0,RESET_CORE_TIMER # for {
    syscall                 # resetCoreTimer();

while_dl:
    li $v0,READ_CORE_TIMER  #
    syscall                 #
    blt $v0,20000,while_dl  # while(readCoreTimer() < 20000);
    addi $t0,$t0,-1
    bgtz $t0,for            # }
    
end_dl:
    jr $ra                  # return;
