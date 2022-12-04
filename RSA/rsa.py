p,q=map(int,input("Enter 2 prime numbers: ").split())
n=p*q
phifunc=(p-1)*(q-1)
e=int(input("Enter a number e which is relatively prime ot phifunc: "))
d=1 
s=(d*e)%phifunc
while s!=1:
    d+=1 
    s=(d*e)%phifunc 

message=int(input("Enter the message: "))
encryptedtext=(message**e)%n 
print("Ciphertext is:",encryptedtext)
decryptedtext=(encryptedtext**d)%n
print("Plaintext is:",decryptedtext)
