#!/bin/sh

pdftotext Load_Shedding_All_Areas_Schedule_and_Map.pdf
cat Load_Shedding_All_Areas_Schedule_and_Map.txt | grep -v '[a-zA-Z]' | grep '[0-9]' | tail -n +8 | grep -v ':' > Load_Shedding_All_Areas_Schedule_and_Map.clean.txt
cat Load_Shedding_All_Areas_Schedule_and_Map.clean.txt | head -`echo $((1536/2))` | \
  perl -ne 'print ((int(($.-1) / 192)+1)."_".((($.-1) % 16)+1)."_".
  sprintf ("%02s", (int(($.-1) / 16 % 12)*2))." $_".
  ((((($.-1) % 16))==15)?"":((int(($.-1) / 192)+1)."_".
  ((($.-1) % 16)+17)."_".
  sprintf ("%02s", (int(($.-1) / 16 % 12)*2)))." $_"));' > Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt
cat Load_Shedding_All_Areas_Schedule_and_Map.clean.txt | tail -`echo $((1536/2))` | \
  perl -ne 'print ((int(($.-1) / 192)+5)."_".((($.-1) % 8)+1+(((int(($.-1)/96) %2)*8)))."_".
  sprintf ("%02s", (int(($.-1) / 8 % 12)*2))." $_".
  (((((($.-1) % 8))==7) && ((int(($.-1)/96)%2)==1))?"":((int(($.-1) / 192)+5)."_".
  ((($.-1) % 8)+1+(((int(($.-1)/96)%2)*8)+16))."_".
  sprintf ("%02s", (int(($.-1) / 8 % 12)*2)))." $_"));' >> Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt
