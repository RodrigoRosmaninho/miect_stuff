    .equ READ_CORE_TIMER,11
    .equ RESET_CORE_TIMER,12
    .equ PUT_CHAR,3
    .equ PRINT_INT,6 
    .data
    .text
    .globl main

######## MAIN ########
# Mapa de Registos
# $s0 : counter

main: 
    li $s0,0
    addi $sp,$sp,-4
    sw $ra, 0($sp)

while:
    li $a0, 1000
    jal delay
    li $v0,RESET_CORE_TIMER #
    syscall                 # resetCoreTimer();
    li $a0,' '              #
    li $v0,PUT_CHAR         #
    syscall                 # putChar(' ');
    addi $s0,$s0,1          #
    move $a0,$s0            #
    li $a1,10               #
    li $v0,PRINT_INT        #
    syscall                 # printInt(++counter, 10);
    b while                 # }
    
endw:
    lw $ra, 0($sp)
    addi $sp,$sp,4
    jr $ra                  #



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