library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity LeftShifter2 is
	generic(N : positive := 32);
	port(dataIn  :  in std_logic_vector((N - 1) downto 0);
		  dataOut : out std_logic_vector((N - 1) downto 0));
end LeftShifter2;

architecture a of LeftShifter2 is
begin
	dataOut <= dataIn((N - 3) downto 0) & "00";
end a;