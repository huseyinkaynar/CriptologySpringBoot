# CriptologySpringBoot
Text Encrypting Web Application



## Encrypt Text


##### POST localhost:8081/encrypt
```bash
{
	
	"textEncrypt": "try text"
	
}
```
##### RESPONSE localhost:8081/encrypt
```bash
{
    "id": 5,
    "textDecrypt": "c9gmcsic",
    "passDecrypt": "32670154"
}
```

## Decrypt Text


##### POST localhost:8081/decrypt
```bash
{
	"passDecrypt":"32670154",
	"textDecrypt":"c9gmcsic"
}
```

##### RESPONSE localhost:8081/encrypt
```bash
{
    "id": 1,
    "passEncrypt": "32670154",
    "textEncrypt": "try text"
}
```
