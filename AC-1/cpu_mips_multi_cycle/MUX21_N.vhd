library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity MUX21_N is
	generic(N   : positive := 32);
	port(In0    :  in std_logic_vector((N - 1) downto 0);
		  In1    :  in std_logic_vector((N - 1) downto 0);
		  sel    :  in std_logic;
		  MuxOut : out std_logic_vector((N - 1) downto 0));
end MUX21_N;

architecture a of MUX21_N is
begin
	MuxOut <= In1 when sel = '1' else In0;
end a;