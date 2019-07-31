    .data
    .equ put_char, 3
    .text
    .globl main

main:
    li $v0, 1
    syscall

while:
    beqz $v0, main
    beq $v0, '\n', exit
    move $a0, $v0
    la $v0, put_char
    syscall
    b main

exit:
    jr $ra