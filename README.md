# Sk-Cuts
Skript addon for new shortcut syntax with optimizations to run as good or sometimes even better than skript!

Syntax for v1.1.1: 

%number% += %number%  
%number% -= %number%  
%number% *= %number%  
%number% /= %number%  
%number% ^= %number%  
%number/boolean/string/player/entity/location/world% == %number/boolean/string/player/entity/location/world%  

examples:  
<pre>
on join:  
 {joins::%player's uuid%} += 1  

command setpoints <number>:  
 trigger:  
  {points::%player's uuid%} == arg-1  
  
on death:  
 {protection::%player's uuid%} == true  
   
on right click:  
 {clicksleft::%player's uuid%} -= 1  
</pre>  
