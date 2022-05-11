package bfprt

import "fmt"

func BFPRT(arr []int, L int, R int, index) int {
	if L == R {
		return arr[L]
	}
	pivot := medianOfMedians(arr, L, R)
}

func medianOfMedians(arr []int, L int, R int) int {
	size := R - L + 1
	offset := 0
	if size%5 != 0 {
		offset += 1
	}
	mArr := make([]int, size/5+offset)
	for i := 0; i < len(mArr); i++ {
		teamFirst := L + i*5
		mArr[i] = getMedian(arr, 0, len(mArr), min(teamFirst+4, R))
	}
}

func getMedian(arr []int, L int, R int)

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	arr := []int{9, 6, 12, 45, 26, 5, 7, 2, 1}
	fmt.Println(BFPRT(arr, 0, len(arr)-1, 3))
}
