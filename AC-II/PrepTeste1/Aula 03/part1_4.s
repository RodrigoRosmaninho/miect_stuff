.equ SFR_BASE_HI, 0xBF88    # 16 MSbits of SFR area
.equ TRISE, 0x6100          # TRISE address is 0xBF886100
.equ LATE, 0x6120           # LATE address is 0xBF886120
.equ READ_CORE_TIMER, 11
.equ RESET_CORE_TIMER, 12
.equ K, 20000
.equ TIME, 500
.data
.text
.globl main

main:
    lui $t1, SFR_BASE_HI        #
    
    lw $t2, TRISE($t1)          # READ (Mem_addr = 0xBF880000 + 0x6100)
    andi $t2, $t2, 0xFFFE       # MODIFY (bit0=bit3=0 (0 means OUTPUT))
    sw $t2, TRISE($t1)          # WRITE (Write TRISE register)

    lw $t2, LATE($t1)           # READ (Read LATE register)
    andi $t2,$t2,0xFFFE
    sw $t2, TRISE($t1)          # WRITE (Write TRISE register)

    addi $sp, $sp, -8
    sw $ra, 0($sp)

while:

    li $a0,TIME
    jal delay

    lui $t1, SFR_BASE_HI        #
    lw $t2, LATE($t1)           # READ (Read LATE register)
    xor $t2,$t2,0x0001
    sw $t2, LATE($t1)           # WRITE (Write LATE register)

    b while

    lw $ra, 0($sp)
    addi $sp, $sp, 8
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

