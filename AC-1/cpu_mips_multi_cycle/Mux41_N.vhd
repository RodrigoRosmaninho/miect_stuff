library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity Mux41_N is
	generic(N   : positive := 32);
	port(In0    :  in std_logic_vector((N - 1) downto 0);
		  In1    :  in std_logic_vector((N - 1) downto 0);
		  In2    :  in std_logic_vector((N - 1) downto 0);
		  In3    :  in std_logic_vector((N - 1) downto 0);
		  sel    :  in std_logic_vector(1 downto 0);
		  MuxOut : out std_logic_vector((N - 1) downto 0));
end Mux41_N;

architecture a of Mux41_N is
begin

	MuxOut <= In3 when sel = "11" else
			  In2 when sel = "10" else
			  In1 when sel = "01" else
			  In0;
end a;