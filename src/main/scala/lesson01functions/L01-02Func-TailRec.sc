import scala.annotation.tailrec

//tail-call - tail-recursive
//use inner helper function with state
def fac2(n: BigInt): BigInt = {

  //compiler will always optimize tail calls
  //but annotation forces check - fail compile if
  //not tail recursive
	@tailrec def loop(currN : BigInt, facSoFar: BigInt): BigInt = {
		if (currN == 1) {
			facSoFar
		} else {
			loop(currN - 1, currN * facSoFar)
		}
	}
	loop(n, 1)
}

//no more stack overflow
fac2(10000)