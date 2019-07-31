.equ SFR_BASE_HI, 0xBF88    # 16 MSbits of SFR area
.equ TRISE, 0x6100          # TRISE address is 0xBF886100
.equ TRISB, 0x6040          #
.equ PORTB, 0x6050          #
.equ LATE, 0x6120           # LATE address is 0xBF886120
.equ TIME, 1000
.equ READ_CORE_TIMER,11
.equ RESET_CORE_TIMER,12
.equ K, 20000
.data
.text
.globl main

main:
    lui $s1, SFR_BASE_HI

    lw $t2, LATE($s1)
    andi $t2, $t2, 0xFFF0
    sw $t2, LATE($s1)

    lw $t2, TRISE($s1)
    andi $t2, $t2, 0xFFF0
    sw $t2, TRISE($s1)

    lw $t2, TRISB($s1)
    ori $t2, $t2, 0x0003
    sw $t2, TRISB($s1)

    li $s0, 0

    addi $sp, $sp, -4
    sw $ra, 0($sp)

while:
    
    li $a0, TIME
    jal delay

    lw $t2, PORTB($s1)
    andi $t2,$t2, 0x0003

    add $s0,$s0,$t2
    and $s0,$s0,0x000F

    lw $t2, LATE($s1)
    andi $t2,$t2, 0xFFF0

    or $t2,$t2,$s0
    sw $t2, LATE($s1)

    j while

    lw $ra, 0($sp)
    addi $sp, $sp, 4

    jr $ra



#### DELAY ####
delay:
    ble $a0,$0,d_exit

    li $v0, RESET_CORE_TIMER
    syscall

d_while:
    li $v0, READ_CORE_TIMER
    syscall

    blt $v0,K,d_while

    addi $a0,$a0, -1

    j delay

d_exit:
    jr $ra