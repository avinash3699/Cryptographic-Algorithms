import hashlib

plaintext=input("Enter Plain text:").strip()
text=hashlib.sha1(plaintext.encode())
ciphertexthex=text.hexdigest()
print("The Cipher text is:",ciphertexthex)
