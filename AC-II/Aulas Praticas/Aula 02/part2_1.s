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

while:
    li $v0,READ_CORE_TIMER  # while (1) {
    syscall                 #
    blt $v0,20000000,while  # while(readCoreTimer() < 2000000);
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
    jr $ra                  #