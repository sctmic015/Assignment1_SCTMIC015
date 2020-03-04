import os
import subprocess


# subprocess.call(["java", "LSArrayApp", "2_2_00"])

for i in range (3):
    file = open("opCountArrayTest.csv", "a+")
    file.write("Test 1")
    file.write("\n")
    for i in range (10):
        subprocess.call(["java", "LSArrayApp", "2_2_00"])
