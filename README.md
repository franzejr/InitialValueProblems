#Initial Value Problem
In mathematics, in the field of differential equations, an initial value problem (also called the Cauchy problem by some authors) is an ordinary differential equation together with a specified value, called the initial condition, of the unknown function at a given point in the domain of the solution. In physics or other sciences, modeling a system frequently amounts to solving an initial value problem; in this context, the differential equation is an evolution equation specifying how, given initial conditions, the system will evolve with time.

#Our function
double g = 9.80665; //Gravity
dy/dt = ( (64.0/1000)*(Math.sqrt(2*g*y)) )/(Math.pow(y, 2))

##Derivative
-0.135765*Math.sqrt(g*y)/(y*y*y)

#Methods

+ Forward Euler
+ Backward Euler
+ Modified Euler
+ Predictor Corrector
