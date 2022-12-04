p=int(input("Enter the prime number: "))
q=int(input("Enter the number less than p: "))

a=int(input("Enter the private key of A: "))
b=int(input("Enter the private key of B: "))

xA=(q**a)%p 
xB=(q**b)%p 

kA=(xB**a)%p 
kB=(xA**b)%p 

print("Secret key of A is ",kA)
print("Secret key of B is ",kB)