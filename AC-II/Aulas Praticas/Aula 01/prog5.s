    .data
    .equ print_string, 8
    .equ print_int, 6
    .equ print_int10, 7 
    .equ read_int10, 5
str1:.asciiz "\nIntroduza 2 strings: "
str2:.asciiz "\nResultados:\n"
    .text
    .globl main

######## MAIN ########
# Mapa de Registos
# $s0 : exit_value

main:


####### STRCMP #######
# Mapa de Registos
# $t0 : s1[i]
# $t1 : s2[i]
# $t2 : *s1[i]
# $t3 : *s2[i]

strcmp:
	move $t0,$a0
	move $t1,$a1
    addi $t0,$t0,-1
    addi $t1,$t1,-1

while_cmp:
    addi $t0,$t0,1
    addi $t1,$t1,1
    lb $t2,0($t0)
    lb $t3,0($t1)
    bne $t2,$t1,while_cmp
	bne $t2,'0',while_cmp

	sub $v0,$t2,$t3
	jr $ra

####### STRCAT #######
# Mapa de Registos
# $t0 : rp
# $t1 : dst[i]
# $t2 : src[i]
# $t3 : *dst[i]

strcat:
	move $t0,$a0
	move $t1,$a0
    move $t2,$a1
    addi $t1,$t1,-1

while_cat:
    addi $t1,$t1,1
    lb $t3,0($t1)
	bne $t3,'0',while_cat

    move $a0,$t1
	move $a1,$t2
	addiu $sp,$sp,-4
	sw $ra,0($sp)
	jal strcpy
	lw $ra,0($sp)
	addiu $sp,$sp,4

	move $v0,$t0
	jr $ra

####### STRCPY #######
# Mapa de Registos
# $t0 : i
# $t1 : dst[i]
# $t2 : src[i]
# $t3 : *src[i]

strcpy:
	move $t0,$zero
	
while_cpy:
	add $t1,$a0,$t0
	add $t2,$a1,$t0
	lb $t3,0($t2)
	sb $t3,0($t1)
	addi $t0,$t0,1
	bne $t3,'0',while_cpy
	
	move $v0,$a0
	jr $ra
	
	
####### STRLEN #######
# Mapa de Registos:
# $t0 : s (pointer)
# $t1 : *s (value)
# $t2 : len

strlen:
	move $t0,$a0
	li $t2,0
	
while_len:
	lb $t1,0($t0)
	addiu $t0,$t0,1
	beq $t1,'0',end_len
	addiu $t2,$t2,1
	b while_len
	
end_len:
	move $v0,$t2
	jr $ra