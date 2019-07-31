.equ SFR_BASE_HI, 0xBF88    # 16 MSbits of SFR area
.equ TRISE, 0x6100          # TRISE address is 0xBF886100
.equ LATE, 0x6120           # LATE address is 0xBF886120
.equ READ_CORE_TIMER, 11
.equ RESET_CORE_TIMER, 12
.equ K, 20000
.equ TIME, 250
.data
.text
.globl main

main:
    lui $t1, SFR_BASE_HI        #

    lw $t2, LATE($t1)           # READ (Read LATE register)
    andi $t2,$t2,0xFFF0
    sw $t2, LATE($t1)          # WRITE (Write LATE register)
    
    lw $t2, TRISE($t1)          # READ (Mem_addr = 0xBF880000 + 0x6100)
    andi $t2, $t2, 0xFFF0       # MODIFY (bit0=bit3=0 (0 means OUTPUT))
    sw $t2, TRISE($t1)          # WRITE (Write TRISE register)

    addi $sp, $sp, -4
    sw $ra, 0($sp)

    li $s0,0x10

while:

    li $a0,TIME
    jal delay

    addi $s0,$s0,-1
    
    move $a0,$s0
    lw $a1,LATE($t1)           # READ (Read LATE register)
    li $a2,0x000F
    jal bit_copy

    lui $t1, SFR_BASE_HI        #
    sw $v0, LATE($t1)           # WRITE (Write LATE register)

    b while

    lw $ra, 0($sp)
    addi $sp, $sp, 4
    jr $ra
    

####### BITCOPY #######
# Mapa de Registos
# $a0 : src (butoes, etc)
# $a1 : dst (leds, etc)
# $a2 : bits a alterar
# $a3 : not($a3)
# $t0 : and butoes, bits a alterar
# $t1 : or butoes, bits a alterar
# $v0 : resultado a colocar no dst

bit_copy:
    not $a3, $a2

    and $t0, $a0, $a2
    or $t1, $a0, $a3

    or $a1, $a1, $t0
    and $v0, $a1, $t1

    jr $ra

####### DELAY #######
delay:
    ble $a0,$0,d_exit
    
    li $v0,RESET_CORE_TIMER
    syscall

d_while:
    li $v0,READ_CORE_TIMER
    syscall
    blt $v0,K,d_while

    addiu $a0,$a0,-1
    j delay

d_exit: 
    jr $ra
