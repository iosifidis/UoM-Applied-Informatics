# Efstathios Iosifidis
.data  # Data segment 
msg1: .asciiz "Give the first number: "
msg2: .asciiz "Give the second number: "
msg3: .asciiz "The result is "

.text  # Code segment
# Load integers into registers
# First number
la $a0, msg1 # Fortono to proto minima ston kataxoriti a0
li $v0, 4 # Fortono to print_string ston v0 kai tou lew na ektipwsei
syscall
li $v0, 5 # Fortono to read_int ston kataxoriti v0 kai perimenei apo ton xristi na dosei timi
syscall
move $t0, $v0 # Antigrafo to noumero apo to v0 ston kataxoriti t0

# Second number 
la $a0, msg2 # Fortono to deftero minima ston kataxoriti a0
li $v0, 4 # Fortono to print_string ston v0 kai tou lew na ektipwsei
syscall
li $v0, 5 # Fortono to read_int ston kataxoriti v0 kai perimenei apo ton xristi na dosei timi
syscall
move $t1, $v0 # Antigrafo to noumero apo to v0 ston kataxoriti t1

# Add integers
add $t2, $t0, $t1 # Prostheto to t0+t1 kai to apothikevo sto t2

#Print message
la $a0, msg3 # Fortono to trito minima ston kataxoriti a0
li $v0, 4 # Fortono to print_string ston v0 kai tou lew na ektipwsei
syscall

# Print result
move $a0, $t2 # Antigrafo to apotelesma apo ton kataxoriti t2 sto a0
li $v0, 1 # Zito na ektiposei to apotelesma print_int
syscall

# Exit
li $v0, 10
syscall
