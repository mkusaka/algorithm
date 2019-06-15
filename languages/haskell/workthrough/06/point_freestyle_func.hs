foo x y = f x ( g y)

foo = \x y -> f x ( g y)
    = \x y -> (f x .g) y
    = \x -> f x. g
    = \x -> (.g) (f x)
    = \x -> ((.g) . f) x
    = (.g).f
