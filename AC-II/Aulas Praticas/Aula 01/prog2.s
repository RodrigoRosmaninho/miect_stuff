    .data
    .equ print_string, 8
str:.asciiz "Key Pressed\n"
    .text
    .globl main

main:
    li $v0, 1
    syscall

while:
    beqz $v0, main
    beq $v0, '\n', exit
    la $a0, str
    la $v0, print_string
    syscall
    b main

exit:
    jr $ra