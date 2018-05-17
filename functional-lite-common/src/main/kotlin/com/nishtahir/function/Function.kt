package com.nishtahir.function

inline fun <A, B, C> ((A) -> B).andThen(crossinline transform: (B) -> C): (A) -> C = { a -> transform(this(a)) }

inline fun <A, B, C> ((A) -> B).compose(crossinline transform: (C) -> A): (C) -> B = { this(transform(it)) }