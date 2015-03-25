# PushdownAutomata

Deterministic Pushdown Automata (PDA)


PDA with stack regognize following Context Free Grammar:
S -> $T$
T -> T+T | T-T | T*T | T/T | (T) | CX
X -> XX | C | N | _ | e
C -> a | b | c | · · · | z
N -> 0 | 1 | 2 | · · · | 9

PDA Diagram:

![alt tag](https://github.com/virajbhalala/PushdownAutomata/blob/master/PDA.png)
