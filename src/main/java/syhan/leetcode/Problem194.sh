# Read from the file file.txt and print its transposed content to stdout.
awk '
{
  for(c = 1; c <= NF; c++) {
    a[c, NR] = $c
  }
  if(max_nf < NF) {
    max_nf = NF
  }
}
END {
  for(r = 1; r <= max_nf; r++) {
    for(c = 1; c <= NR; c++) {
      printf("%s ", a[r, c])
    }
    print ""
  }
}
' file.txt | sed -r 's/ $//g'