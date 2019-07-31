.equ SFR_BASE_HI, 0xBF88    # 16 MSbits of SFR area
.equ TRISE, 0x6100          # TRISE address is 0xBF886100
.equ TRISB, 0x6040          #
.equ PORTB, 0x6050          #
.equ PORTE, 0x6110          # PORTE address is 0xBF886110
.equ LATE, 0x6120           # LATE address is 0xBF886120
.data
.text
.globl main

main:
    lui $t1, SFR_BASE_HI        #
    
    lw $t2, TRISE($t1)          # READ (Mem_addr = 0xBF880000 + 0x6100)
    andi $t2, $t2, 0xFFFE       # MODIFY (bit0=bit3=0 (0 means OUTPUT))
    sw $t2, TRISE($t1)          # WRITE (Write TRISE register)

    lw $t2, TRISB($t1)          # READ (Mem_addr = 0xBF880000 + 0x6040)
    ori $t2, $t2, 0x0001        # MODIFY (bit0 = 1)
    sw $t2, TRISB($t1)          # WRITE (Write TRISB register)

    addi $sp, $sp, -4
    sw $ra, 0($sp)

while:
    
    lw $a0, PORTB($t1)
    not $a0,$a0
    lw $a1, LATE($t1)           # READ (Read LATE register)
    li $a2, 1;

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