package kmp

func getIndexof(str1 string, str2 string) int {
	next := getNext(str2)
	j := 0
	for i := 1; i < len(str1); i++ {
		for j > 0 && str1[i] != str2[j] {
			j = next[j-1]
		}
		if str1[i] == str2[j] {
			j++
		}
		if j == len(str2) {
			return i - j + 1
		}
	}
	return -1
}

func getNext(s string) []int {
	if len(s) == 1 {
		return []int{0}
	}
	next := make([]int, len(s))
	next[0] = 0
	j := 0
	for i := 1; i < len(s); i++ {
		for j > 0 && s[i] != s[j] {
			j = next[j-1]
		}
		if s[i] == s[j] {
			j++
		}
		next[i] = j
	}
	return next
}
