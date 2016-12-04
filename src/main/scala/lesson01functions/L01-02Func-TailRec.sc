import scala.annotation.tailrec

//tail-call - tail-recursive
def fac2(n: BigInt): BigInt = {
	@tailrec def loop(currN : BigInt, facSoFar: BigInt): BigInt = {
		if (currN == 1) {
			facSoFar
		} else {
			loop(currN - 1, currN * facSoFar)
		}
	}
	loop(n, 1)
}

fac2(10000)