import random

# (Waterman's "Reservoir Algorithm") from Knuth's "The Art of Computer Programming"
def random_line(afile):
    line = next(afile)
    for num, aline in enumerate(afile, 2):
      if random.randrange(num): continue
      line = aline
    return line

file = open("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt", "r")
print(random_line(file))

file2 = open("opCOunt2.csv", "a+")
for i in range (10):
    line = "subset:" + str(i) + ".txt"
    changeFile = open(line, "a+")
    changeFile.write(line)
    changeFile.write('\n')
    for j in range ((i+1) * 297):
        changeFile.write(random_line(open("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt", "r")))
