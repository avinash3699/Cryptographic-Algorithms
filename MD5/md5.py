import hashlib

plaintext=input("Enter Plain text:").strip()
text=hashlib.md5(plaintext.encode())
ciphertexthex=text.hexdigest()
print("The Cipher text is:",ciphertexthex)
