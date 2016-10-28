
n = int(raw_input())
str1 = []
for i in range(n):
	str2 = raw_input().strip()
	str1.append(str2)
for i in range(n):
	str3 = str1[i]
	str4 = str3[::-1]
	if str3 == str4 :
		print "YES" ,
		if len(str3)%2 == 0:
			print "EVEN" 
		else:
			print "ODD"
	else:
		print "NO"

