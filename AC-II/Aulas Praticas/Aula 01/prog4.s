    .data
    .equ print_string, 8
    .equ print_int, 6
    .equ print_int10, 7 
    .equ read_int10, 5
str1:.asciiz "\n\nIntroduza um numero (sinal e módulo): "
str2:.asciiz "\nValor lido em base 2: "
str3:.asciiz "\nValor lido em base 16: "
str4:.asciiz "\nValor lido em base 10 (unsigned): "
str5:.asciiz "\nValor lido em base 10 (signed): "
    .text
    .globl main

main:
    la $v0, print_string
    la $a0, str1 
    syscall
    la $v0, read_int10
    syscall
    move $s1,$v0
    
    la $v0, print_string
    la $a0, str2
    syscall
    la $v0, print_int
    move $a0, $s1
    li $a1, 2
    syscall

    la $v0, print_string
    la $a0, str3
    syscall
    la $v0, print_int
    move $a0, $s1
    li $a1, 16
    syscall

    la $v0, print_string
    la $a0, str4
    syscall
    la $v0, print_int
    move $a0, $s1
    li $a1, 10
    syscall

    la $v0, print_string
    la $a0, str5
    syscall
    la $v0, print_int10
    move $a0, $s1
    syscall

    b main
