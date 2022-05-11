package kmp

import "strconv"

type Node struct {
	value int
	left  *Node
	right *Node
}

func (node *Node) newNode(value int) {
	node.value = value
}

func (node *Node) serialize() []string {
	l := make([]string, 10)
	pres(node, l)
	return l
}

func pres(node *Node, l []string) {
	if node == nil {
		l = append(l, "")
	}
	l = append(l, strconv.Itoa(node.value))
	pres(node.left, l)
	pres(node.right, l)
}

func getIndex
