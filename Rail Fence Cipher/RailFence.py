plaintext=input("Enter the plaintext: ").strip()
depth=int(input("Enter the depth: "))
ciphertext=""
for i in range(depth):
    for j in range(i,len(plaintext),depth):
        ciphertext+=plaintext[j]
print("The ciphertext is:",ciphertext)