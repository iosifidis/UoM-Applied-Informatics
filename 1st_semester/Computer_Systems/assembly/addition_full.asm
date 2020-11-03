.data  # Data segment 
msg: .ascii "The result is "

.text  # Code segment
# Load integers into registers
li $t0, 10
li $t1, 15

# Add integers
add $t2, $t0, $t1

#Print message
la $a0, msg
li $v0, 4
syscall

# Print result
move $a0, $t2
li $v0, 1
syscall

# Exit
li $v0, 10
syscall
