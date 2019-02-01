library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity ALUcontrol is
	port(ALUop 		 :  in std_logic_vector(1 downto 0);
		  funct 		 :  in std_logic_vector(5 downto 0);
		  ALUcontrol : out std_logic_vector(2 downto 0));
end ALUcontrol;

architecture a of ALUcontrol is
begin
	process(ALUop, funct)
	begin
		if(ALUop = "00") then -- ADD (LW,SW,ADDI)
			ALUcontrol <= "010";
		elsif(ALUop = "01") then -- SUB (BEQ)
			ALUcontrol <= "110";
		elsif(ALUop = "10") then -- R-Type
			case funct is
				when "100000" => ALUcontrol <= "010"; -- ADD
				when "100010" => ALUcontrol <= "110"; -- SUB
				when "100100" => ALUcontrol <= "000"; -- AND
				when "100101" => ALUcontrol <= "001"; -- OR
				when "101010" => ALUcontrol <= "111"; -- SLT
				when others => ALUcontrol <= "010"; 
			end case;
		else -- SLTI
			ALUcontrol <= "111";
		end if;
	end process;
end a;