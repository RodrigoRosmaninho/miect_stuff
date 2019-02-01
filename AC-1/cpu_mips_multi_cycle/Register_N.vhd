library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity Register_N is
	generic(N : positive := 32);
	port(clk    :  in std_logic;
		  enable :  in std_logic;
		  valIn  :  in std_logic_vector((N - 1) downto 0);
		  valOut : out std_logic_vector((N - 1) downto 0));
end Register_N;

architecture a of Register_N is
	signal s_data : std_logic_vector((N - 1) downto 0);
begin
	process(clk)
	begin
		if(rising_edge(clk)) then
			if(enable = '1') then
				s_data <= valIn;
			end if;
		end if;
	end process;
	
	valOut <= s_data;
	
end a;