# 基本構造
class Number < Struct.new(:value)
end

class Add < Struct.new(:left, :right)
end

class Multiply < Struct.new(:left, :right)
end


# 表示をよしなにするメソッド
class Number
  def to_s
    value.to_s
  end

  def inspect
    "<<#{self}>>"
  end
end

class Add
  def to_s
    "#{left} + #{right}"
  end

  def inspect
    "<<#{self}>>"
  end
end

class Multiply
  def to_s
    "#{left} * #{right}"
  end

  def inspect
    "<<#{self}>>"
  end
end

# 簡約可能か？
class Number
  def reducible?
    false
  end
end

class Add
  def reducible?
    true
  end
end

class Multiply
  def reducible?
    true
  end
end


=begin
Add.new(
  Multiply.new(
    Number.new(1),
    Number.new(2)
  ),
  Multiply.new(
    Number.new(3),
    Number.new(4)
  )
)
Number.new(1).reducible?
=> false
=end

# 監訳するメソッド郡
class Add
  def reduce
    if left.reducible?
      Add.new(left.reduce, right)
    elsif right.reducible?
      Add.new(left, right.reduce)
    else
      Number.new(left.value + right.value)
    end
  end
end

class Multiply
  def reduce
    if left.reducible?
      Multiply.new(left.reduce, right)
    elsif right.reducible?
      Multiply.new(left, right.reduce)
    else
      Number.new(left.value * right.value)
    end
end

=begin
epressin = Add.new(
  Multiply.new(
    Number.new(1),
    Number.new(2)
  ),
  Multiply.new(
    Number.new(3),
    Number.new(4)
  )
)
expression.reduce
epxression.reduce ...
=end

# 簡約をやってくれる仮想機械
class Machine < Struct.new(:expression)
  def step
    self.expression = expression.reduce
  end

  def run
    while expression.reducible?
      puts expression
      step
    end
    puts expression
  end
end

# Machine.new(
#   Add.new(
#     Multiply.new(
#       Number.new(1),
#       Number.new(2)
#     ),
#     Multiply.new(
#       Number.new(3),
#       Number.new(4)
#     )
#   )
# )

# numberなど以外のclassたち
class Boolean < Struct.new(:value)
  def to_s
    value.to_s
  end

  def inspect
    "<<#{self}>>"
  end

  def reducible?
    false
  end
end

class LessThan < Struct.new(:left, :right)
  def to_s
    "#{left} < #{right}"
  end

  def inspect
    "<<#{self}>>"
  end

  def reducible?
    true
  end

  def reduce
    if left.reducible?
      LessThan.new(left.reduce, right)
    elsif righ.reducible?
      LessThan.new(left, right.reduce)
    else
      Boolean.new(left.value < right.value)
    end
end

=begin
Machine.new(
  LessThan/new(Number.new(5), Add.new(Number.new(2), NUmber.new(2)))
)
=end
