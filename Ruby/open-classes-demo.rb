class C1
  def foo
    puts "C1.foo"
  end

  def [](i)
    puts "C1[#{i}]"
  end
end

C1.class_eval do
  def foo
    puts "C1.foo redefined"
  end

  def [](i)
    puts "C1[#{i}] redefined"
  end
end

class C2 < C1
  def [](i)
    puts "C2[#{i}]"
  end
end

C2.class_eval do
  def [](i)
    puts "C2[#{i}] redefined"
  end
end

if __FILE__ == $0
  c1 = C1.new
  c1.foo
  c1[1]

  c2 = C2.new
  c2.foo
  c2[2]
end