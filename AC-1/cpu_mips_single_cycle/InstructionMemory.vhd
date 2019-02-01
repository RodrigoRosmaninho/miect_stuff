library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

library work;
use work.DisplayUnit_pkg.all;

entity InstructionMemory is
	generic(ADDR_BUS_SIZE : positive := 6);
	port(readAddr :  in std_logic_vector((ADDR_BUS_SIZE - 1) downto 0);
		  Instr    : out std_logic_vector(31 downto 0));
end InstructionMemory;

architecture a of InstructionMemory is
	constant NUM_WORDS : positive := (2 ** ADDR_BUS_SIZE);
	subtype TData is std_logic_vector(31 downto 0);
	type TMemory is array(0 to NUM_WORDS - 1) of TData;
	constant s_memory : TMemory := (X"20050000", -- VER PDF AULA PRATICA 10
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
											  others => X"00000000"); -- nop
begin
	Instr <= s_memory(to_integer(unsigned(readAddr)));
	
	-- Ponto de leitura para efeitos de visualização (ligado ao módulo
	-- de visualização através dos sinais globais DU_IMaddr e DU_IMdata)
	DU_IMdata <= s_memory(to_integer(unsigned(DU_IMaddr)));
end a;