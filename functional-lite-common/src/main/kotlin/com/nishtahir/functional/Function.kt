package com.nishtahir.functional

inline fun <A, B, C> ((A) -> B).andThen(crossinline transform: (B) -> C): (A) -> C = { a -> transform(this(a)) }
