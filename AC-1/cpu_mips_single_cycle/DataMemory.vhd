library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity DataMemory is
	generic(ADDR_BUS_SIZE : positive := 6;
		     DATA_BUS_SIZE : positive := 32);
	port(clk         :  in std_logic;
		  readEnable  :  in std_logic;
		  writeEnable :  in std_logic;
		  addr        :  in std_logic_vector((ADDR_BUS_SIZE - 1) downto 0);
		  addr2       :  in std_logic_vector((ADDR_BUS_SIZE - 1) downto 0);
		  writeData   :  in std_logic_vector((DATA_BUS_SIZE - 1) downto 0);
		  readData    : out std_logic_vector((DATA_BUS_SIZE - 1) downto 0);
		  readData2   : out std_logic_vector((DATA_BUS_SIZE - 1) downto 0));
end DataMemory;

architecture a of DataMemory is
	constant NUM_WORDS : positive := (2 ** ADDR_BUS_SIZE);
	subtype TData is std_logic_vector(DATA_BUS_SIZE - 1 downto 0);
	type TMemory is array(0 to NUM_WORDS - 1) of TData;
	signal s_memory : TMemory := (-- .data
											-- array: .word 20, 17, -2, 25, 5, -1
											X"00000014", -- .word 20
											X"00000011", -- .word 17
											X"FFFFFFFE", -- .word -2
											X"00000019", -- .word 25
											X"00000005", -- .word 5
											X"FFFFFFFF", -- .word -1
											others => X"00000000");
	
begin

	process(clk)
	begin
		if(rising_edge(clk)) then
			if(writeEnable = '1') then
				s_memory(to_integer(unsigned(addr))) <= writeData;
			end if;
		end if;
	end process;

	readData <= s_memory(to_integer(unsigned(addr))) when readEnable = '1' else 
	            (others => '-');
					
	readData2 <= s_memory(to_integer(unsigned(addr2)));

end a;