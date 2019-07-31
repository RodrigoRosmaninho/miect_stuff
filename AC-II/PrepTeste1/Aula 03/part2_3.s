.equ SFR_BASE_HI, 0xBF88    # 16 MSbits of SFR area
.equ TRISE, 0x6100          # TRISE address is 0xBF886100
.equ TRISB, 0x6040          #
.equ PORTB, 0x6050          #
.equ PORTE, 0x6110          # PORTE address is 0xBF886110
.equ LATE, 0x6120           # LATE address is 0xBF886120
.equ READ_CORE_TIMER, 11
.equ RESET_CORE_TIMER, 12
.equ K, 20000
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

    lw $t2, TRISB($t1)
    ori $t2,$t2,0x0008
    sw $t2, TRISB($t1)

    addi $sp,$sp,-4
    sw $ra, 0($sp)

    li $s0, 0

while:
    lw $t2, PORTB($t1)
    and $t2,$t2,0x0008
    
if:
    beq $t2,$0,else
    addi $s0,$s0,1
    j endif

else:
    addi $s0,$s0,-1

endif:
    lw $t2, LATE($t1)
    andi $t2,$t2,0xFFF0
    andi $t3,$s0,0x000F
    or $t2,$t2,$t3
    sw $t2, LATE($t1)

    li $a0,250
    jal delay

    lui $t1, SFR_BASE_HI
    j while

    lw $ra, 0($sp)
    addi $ra,$ra,4
    jr $ra



### DELAY ###
delay:
    ble $a0, $0, d_end
    
    li $v0, RESET_CORE_TIMER
    syscall

d_while:
    li $v0, READ_CORE_TIMER
    syscall
    blt $v0,K,d_while

    addi $a0,$a0,-1
    j delay

d_end:
    jr $ra

    
