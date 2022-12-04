def keygen(text,key):
    if len(key)!=len(text):
        for i in range(len(text)-len(key)):
            key+=key[i%len(text)]
    return key
    
def encrypt(text,key):
    ciphertext=""
    for i in range(len(text)):
        alph=(ord(text[i])+ord(key[i]))%97
        alph=(alph%26)+97
        ciphertext+=chr(alph)
    return ciphertext
    
text=input("Enter plain text: ").strip()
key=input("Enter key: ").strip()
finalkey=keygen(text,key)
ciphertext=encrypt(text,finalkey)
print("The cipher text:",ciphertext)