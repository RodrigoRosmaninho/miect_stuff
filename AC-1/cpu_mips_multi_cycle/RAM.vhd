library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

library work;
use work.MIPS_pkg.all;
use work.DisplayUnit_pkg.all;

entity RAM is
	generic(ADDR_BUS_SIZE : positive := 6;
			  DATA_BUS_SIZE : positive := 32);
	port(clk         :    in std_logic;
		  writeEnable :    in std_logic;
		  readEnable  :    in std_logic;
		  addr        :    in std_logic_vector((ADDR_BUS_SIZE - 1) downto 0);
		  data        : inout std_logic_vector((DATA_BUS_SIZE - 1) downto 0)); 
end RAM;

architecture a of RAM is
	constant NUM_WORDS : positive := (2 ** ADDR_BUS_SIZE);
	subtype TData is std_logic_vector(DATA_BUS_SIZE - 1 downto 0);
	type TMemory is array(0 to NUM_WORDS - 1) of TData;
	signal s_memory : TMemory := (-- .text (address = 0x00)
											X"20050080", -- VER PDF AULA PRATICA 10 / 11 & 12
										   X"20040005",
										   X"20020001",
										   X"20030000",
										   X"0064082a",
										   X"1020000c",
										   X"00633020",
										   X"00c63020",
										   X"00c53020",
										   X"8cc70000",
										   X"8cc80004",
										   X"0107082a",
										   X"10200003",
										   X"acc70004",
										   X"acc80000",
										   X"20020000",
										   X"20630001",
										   X"08000004",
										   X"2084ffff",
										   X"1040ffee",
										   X"00000000",
										   X"1000ffff",
											X"00000000",
											X"00000000",
											X"00000000",
											X"00000000",
											X"00000000",
											X"00000000",
											X"00000000",
											X"00000000",
											X"00000000",
											X"00000000",
											-- .data (address = 0x80) 
											-- array: .word 20, 17, -2, 25, 5, -1
											X"00000014", -- .word 20
											X"00000011", -- .word 17
											X"FFFFFFFE", -- .word -2
											X"00000019", -- .word 25
											X"00000005", -- .word 5
											X"FFFFFFFF", -- .word -1
										   others => X"00000000"); -- nop
begin
	
	process(clk)
	begin
		if(rising_edge(clk)) then
			if(writeEnable = '1') then
				s_memory(to_integer(unsigned(addr))) <= data;
			end if;
		end if;
	end process;
	
	-- Tri-State Buffer control
	data <= s_memory(to_integer(unsigned(addr))) when readEnable = '1' and writeEnable = '0' else (others=>'Z');
	
	DU_IMdata <= s_memory(to_integer(unsigned(DU_IMaddr)));
	DU_DMdata <= s_memory(to_integer(unsigned(DU_DMaddr)));
	
end a;