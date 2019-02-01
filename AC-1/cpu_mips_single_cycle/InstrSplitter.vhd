library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity InstrSplitter is
	port(Instr  :  in std_logic_vector(31 downto 0);
		  opcode : out std_logic_vector(5 downto 0);
		  rs     : out std_logic_vector(4 downto 0);
		  rt     : out std_logic_vector(4 downto 0);
		  rd     : out std_logic_vector(4 downto 0);
		  shamt  : out std_logic_vector(4 downto 0);
		  funct  : out std_logic_vector(5 downto 0);
		  imm    : out std_logic_vector(15 downto 0);
		  jAddr  : out std_logic_vector(25 downto 0));
end InstrSplitter;

architecture a of InstrSplitter is
begin
	opcode <= Instr(31 downto 26);
	rs <= Instr(25 downto 21);
	rt <= Instr(20 downto 16);
	rd <= Instr(15 downto 11);
	shamt <= Instr(10 downto 6);
	funct <= Instr(5 downto 0);
	imm <= Instr(15 downto 0);
	jAddr <= Instr(25 downto 0);
end a;