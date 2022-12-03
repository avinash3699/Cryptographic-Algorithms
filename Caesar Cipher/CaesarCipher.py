def encrypt(pt,k):
    pt=pt.split()
    ct=""
    for i in pt:
        for j in i:
            alph=ord(j)+(k%26)
            if j.islower():
                if alph>ord('z'):
                    alph-=26
            else:
                if alph>ord('Z'):
                    alph-=26
            ct+=chr(alph) 
        ct+=" "
    return ct
    
def decrypt(ct,k):
    ct=ct.split()
    pt=""
    for i in ct:
        for j in i:
            alph=ord(j)-(k%26)
            if j.islower():
                if alph<ord('a'):
                    alph+=26
            else:
                if alph<ord('A'):
                    alph+=26
            pt+=chr(alph) 
        pt+=" "
    return pt    

print("Enter Plaintext: ",end="")
plaintext=input().strip()
print("Enter key: ",end="")
k=int(input())
ciphertext=encrypt(plaintext,k)
print("Ciphertext:",ciphertext)
decryptedtext=decrypt(ciphertext,k)
print("Plaintext:",decryptedtext)

