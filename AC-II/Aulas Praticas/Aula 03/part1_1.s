    .equ SFR_BASE_HI, 0xBF88    # 16 MSbits of SFR area
    .equ TRISE, 0x6100          # TRISE address is 0xBF886100
    .equ TRISB, 0x6040          # TRISB address is 0xBF886040
    .equ PORTE, 0x6110          # PORTE address is 0xBF886110
    .equ LATE, 0x6120           # LATE address is 0xBF886120
    .equ PORTB, 0x6050          # PORTB address is 0xBF886060
    .data
    .text
    .globl main

main:
    addi $sp, $sp, -4
    sw $ra, 0($sp)

    lui $s1, SFR_BASE_HI        #
    lw $t2, TRISE($s1)          # READ (Mem_addr = 0xBF880000 + 0x6100)
    andi $t2, $t2, 0xFFFE       # MODIFY (bit0=0 (0 means OUTPUT))
    sw $t2, TRISE($s1)          # WRITE (Write TRISE register)
    lw $t2, TRISB($s1)          # READ (Mem_addr = 0xBF880000 + 0x6040)
    ori $t2, $t2, 0x0001        # MODIFY (bit0=1 (1 means INPUT))
    sw $t2, TRISB($s1)          # WRITE (Write TRISB register)

while:
    lw $a0, PORTB($s1)           # READ (Read PORTB register)
    lw $a1, LATE($s1)
    
    #andi $t4, $t2, 0x0001
    #ori $t5, $t2, 0xFFFE

    #or $t3, $t3, $t4
    #and $t2, $t3, $t5

    li $a2, 0x0001
    jal bit_copy
    
    sw $v0, LATE($s1)           # WRITE (Write LATE register)
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