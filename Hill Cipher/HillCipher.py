def encrypt(text,key):
    if text.isupper():
        ptvalue=[ord(i)-65 for i in text]
    else:
        ptvalue=[ord(i)-97 for i in text]
    encryptedtext=""
    for i in range(3):
        ctvalue=0
        for j in range(3):
            ctvalue+=ptvalue[j]*key[i][j]
        if text.isupper():
            encryptedtext+=chr(ctvalue%26+65)
        else:
            encryptedtext+=chr(ctvalue%26+97)
    return encryptedtext
    
string=input("Enter Plain Text:").split()
key=[list(map(int,input("Enter the key:").split())) for i in range(3)]
ciphertext=""
for i in string:
    ciphertext+=encrypt(i,key)
    ciphertext+=" "
print("The Cipher Text:",ciphertext)
