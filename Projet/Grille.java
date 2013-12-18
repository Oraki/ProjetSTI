package sudoku;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.*;
import java.awt.EventQueue;

public class Grille  extends JFrame implements MouseListener {
	
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_39;
	private JTextField textField_36;
	private JTextField textField_35;
	private JTextField textField_34;
	private JTextField textField_38;
	private JTextField textField_37;
	private JTextField textField_101;
	private JTextField textField_102;
	private JTextField textField_103;
	private JTextField textField_104;
	private JTextField textField_105;
	private JTextField textField_106;
	private JTextField textField_107;
	private JTextField textField_108;
	private JTextField textField_109;
	private JTextField textField_111;
	private JTextField textField_112;
	private JTextField textField_113;
	private JTextField textField_114;
	private JTextField textField_115;
	private JTextField textField_116;
	private JTextField textField_117;
	private JTextField textField_118;
	private JTextField textField_119;
	private JTextField textField_121;
	private JTextField textField_122;
	private JTextField textField_123;
	private JTextField textField_124;
	private JTextField textField_125;
	private JTextField textField_126;
	private JTextField textField_127;
	private JTextField textField_128;
	private JTextField textField_129;
	private JTextField textField_191;
	private JTextField textField_192;
	private JTextField textField_193;
	private JTextField textField_194;
	private JTextField textField_195;
	private JTextField textField_196;
	private JTextField textField_197;
	private JTextField textField_198;
	private JTextField textField_199;
	private JTextField textField_201;
	private JTextField textField_202;
	private JTextField textField_203;
	private JTextField textField_204;
	private JTextField textField_205;
	private JTextField textField_206;
	private JTextField textField_207;
	private JTextField textField_208;
	private JTextField textField_209;
	private JTextField textField_211;
	private JTextField textField_212;
	private JTextField textField_213;
	private JTextField textField_214;
	private JTextField textField_215;
	private JTextField textField_216;
	private JTextField textField_217;
	private JTextField textField_218;
	private JTextField textField_219;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_67;
	private JTextField textField_69;
	private JTextField textField_68;
	private JTextField textField_131;
	private JTextField textField_132;
	private JTextField textField_133;
	private JTextField textField_141;
	private JTextField textField_142;
	private JTextField textField_143;
	private JTextField textField_151;
	private JTextField textField_152;
	private JTextField textField_153;
	private JTextField textField_134;
	private JTextField textField_135;
	private JTextField textField_136;
	private JTextField textField_144;
	private JTextField textField_145;
	private JTextField textField_146;
	private JTextField textField_154;
	private JTextField textField_155;
	private JTextField textField_156;
	private JTextField textField_137;
	private JTextField textField_138;
	private JTextField textField_139;
	private JTextField textField_147;
	private JTextField textField_148;
	private JTextField textField_149;
	private JTextField textField_157;
	private JTextField textField_158;
	private JTextField textField_159;
	private JTextField textField_221;
	private JTextField textField_222;
	private JTextField textField_223;
	private JTextField textField_231;
	private JTextField textField_232;
	private JTextField textField_233;
	private JTextField textField_241;
	private JTextField textField_242;
	private JTextField textField_243;
	private JTextField textField_224;
	private JTextField textField_225;
	private JTextField textField_226;
	private JTextField textField_234;
	private JTextField textField_235;
	private JTextField textField_236;
	private JTextField textField_244;
	private JTextField textField_245;
	private JTextField textField_246;
	private JTextField textField_227;
	private JTextField textField_228;
	private JTextField textField_229;
	private JTextField textField_237;
	private JTextField textField_238;
	private JTextField textField_239;
	private JTextField textField_247;
	private JTextField textField_248;
	private JTextField textField_249;
	private JTextField textField_71;
	private JTextField textField_72;
	private JTextField textField_73;
	private JTextField textField_81;
	private JTextField textField_82;
	private JTextField textField_83;
	private JTextField textField_91;
	private JTextField textField_92;
	private JTextField textField_93;
	private JTextField textField_74;
	private JTextField textField_75;
	private JTextField textField_76;
	private JTextField textField_84;
	private JTextField textField_85;
	private JTextField textField_86;
	private JTextField textField_94;
	private JTextField textField_95;
	private JTextField textField_96;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTextField textField_87;
	private JTextField textField_88;
	private JTextField textField_89;
	private JTextField textField_97;
	private JTextField textField_99;
	private JTextField textField_98;
	private JTextField textField_161;
	private JTextField textField_162;
	private JTextField textField_163;
	private JTextField textField_171;
	private JTextField textField_172;
	private JTextField textField_173;
	private JTextField textField_181;
	private JTextField textField_182;
	private JTextField textField_183;
	private JTextField textField_164;
	private JTextField textField_165;
	private JTextField textField_166;
	private JTextField textField_174;
	private JTextField textField_175;
	private JTextField textField_176;
	private JTextField textField_184;
	private JTextField textField_185;
	private JTextField textField_186;
	private JTextField textField_167;
	private JTextField textField_168;
	private JTextField textField_169;
	private JTextField textField_177;
	private JTextField textField_178;
	private JTextField textField_179;
	private JTextField textField_187;
	private JTextField textField_188;
	private JTextField textField_189;
	private JTextField textField_251;
	private JTextField textField_252;
	private JTextField textField_253;
	private JTextField textField_261;
	private JTextField textField_262;
	private JTextField textField_263;
	private JTextField textField_271;
	private JTextField textField_272;
	private JTextField textField_273;
	private JTextField textField_254;
	private JTextField textField_255;
	private JTextField textField_256;
	private JTextField textField_264;
	private JTextField textField_265;
	private JTextField textField_266;
	private JTextField textField_274;
	private JTextField textField_275;
	private JTextField textField_276;
	private JTextField textField_257;
	private JTextField textField_258;
	private JTextField textField_259;
	private JTextField textField_267;
	private JTextField textField_268;
	private JTextField textField_269;
	private JTextField textField_277;
	private JTextField textField_278;
	private JTextField textField_279;
	private JTextField textField_281;
	private JTextField textField_282;
	private JTextField textField_283;
	private JTextField textField_291;
	private JTextField textField_292;
	private JTextField textField_293;
	private JTextField textField_301;
	private JTextField textField_302;
	private JTextField textField_303;
	private JTextField textField_284;
	private JTextField textField_285;
	private JTextField textField_286;
	private JTextField textField_294;
	private JTextField textField_295;
	private JTextField textField_296;
	private JTextField textField_304;
	private JTextField textField_305;
	private JTextField textField_306;
	private JTextField textField_287;
	private JTextField textField_288;
	private JTextField textField_289;
	private JTextField textField_297;
	private JTextField textField_298;
	private JTextField textField_299;
	private JTextField textField_307;
	private JTextField textField_309;
	private JTextField textField_308;
	private JTextField textField_371;
	private JTextField textField_372;
	private JTextField textField_373;
	private JTextField textField_381;
	private JTextField textField_382;
	private JTextField textField_383;
	private JTextField textField_391;
	private JTextField textField_392;
	private JTextField textField_393;
	private JTextField textField_374;
	private JTextField textField_375;
	private JTextField textField_376;
	private JTextField textField_384;
	private JTextField textField_385;
	private JTextField textField_386;
	private JTextField textField_394;
	private JTextField textField_395;
	private JTextField textField_396;
	private JTextField textField_377;
	private JTextField textField_378;
	private JTextField textField_379;
	private JTextField textField_387;
	private JTextField textField_388;
	private JTextField textField_389;
	private JTextField textField_397;
	private JTextField textField_398;
	private JTextField textField_399;
	private JTextField textField_461;
	private JTextField textField_462;
	private JTextField textField_463;
	private JTextField textField_471;
	private JTextField textField_472;
	private JTextField textField_473;
	private JTextField textField_481;
	private JTextField textField_482;
	private JTextField textField_483;
	private JTextField textField_464;
	private JTextField textField_465;
	private JTextField textField_466;
	private JTextField textField_474;
	private JTextField textField_475;
	private JTextField textField_476;
	private JTextField textField_484;
	private JTextField textField_485;
	private JTextField textField_486;
	private JTextField textField_467;
	private JTextField textField_468;
	private JTextField textField_469;
	private JTextField textField_477;
	private JTextField textField_478;
	private JTextField textField_479;
	private JTextField textField_487;
	private JTextField textField_488;
	private JTextField textField_489;
	private JTextField textField_311;
	private JTextField textField_312;
	private JTextField textField_313;
	private JTextField textField_321;
	private JTextField textField_322;
	private JTextField textField_323;
	private JTextField textField_331;
	private JTextField textField_332;
	private JTextField textField_333;
	private JTextField textField_314;
	private JTextField textField_315;
	private JTextField textField_316;
	private JTextField textField_324;
	private JTextField textField_325;
	private JTextField textField_326;
	private JTextField textField_334;
	private JTextField textField_335;
	private JTextField textField_336;
	private JTextField textField_317;
	private JTextField textField_318;
	private JTextField textField_319;
	private JTextField textField_327;
	private JTextField textField_328;
	private JTextField textField_329;
	private JTextField textField_337;
	private JTextField textField_339;
	private JTextField textField_338;
	private JTextField textField_401;
	private JTextField textField_402;
	private JTextField textField_403;
	private JTextField textField_411;
	private JTextField textField_412;
	private JTextField textField_413;
	private JTextField textField_421;
	private JTextField textField_422;
	private JTextField textField_423;
	private JTextField textField_404;
	private JTextField textField_405;
	private JTextField textField_406;
	private JTextField textField_414;
	private JTextField textField_415;
	private JTextField textField_416;
	private JTextField textField_424;
	private JTextField textField_425;
	private JTextField textField_426;
	private JTextField textField_407;
	private JTextField textField_408;
	private JTextField textField_409;
	private JTextField textField_417;
	private JTextField textField_418;
	private JTextField textField_419;
	private JTextField textField_427;
	private JTextField textField_428;
	private JTextField textField_429;
	private JTextField textField_491;
	private JTextField textField_492;
	private JTextField textField_493;
	private JTextField textField_501;
	private JTextField textField_502;
	private JTextField textField_503;
	private JTextField textField_511;
	private JTextField textField_512;
	private JTextField textField_513;
	private JTextField textField_494;
	private JTextField textField_495;
	private JTextField textField_496;
	private JTextField textField_504;
	private JTextField textField_505;
	private JTextField textField_506;
	private JTextField textField_514;
	private JTextField textField_515;
	private JTextField textField_516;
	private JTextField textField_497;
	private JTextField textField_498;
	private JTextField textField_499;
	private JTextField textField_507;
	private JTextField textField_508;
	private JTextField textField_509;
	private JTextField textField_517;
	private JTextField textField_518;
	private JTextField textField_519;
	private JTextField textField_341;
	private JTextField textField_342;
	private JTextField textField_343;
	private JTextField textField_351;
	private JTextField textField_352;
	private JTextField textField_353;
	private JTextField textField_361;
	private JTextField textField_362;
	private JTextField textField_363;
	private JTextField textField_344;
	private JTextField textField_345;
	private JTextField textField_346;
	private JTextField textField_354;
	private JTextField textField_355;
	private JTextField textField_356;
	private JTextField textField_364;
	private JTextField textField_365;
	private JTextField textField_366;
	private JTextField textField_347;
	private JTextField textField_348;
	private JTextField textField_349;
	private JTextField textField_357;
	private JTextField textField_358;
	private JTextField textField_359;
	private JTextField textField_367;
	private JTextField textField_369;
	private JTextField textField_368;
	private JTextField textField_431;
	private JTextField textField_432;
	private JTextField textField_433;
	private JTextField textField_441;
	private JTextField textField_442;
	private JTextField textField_443;
	private JTextField textField_451;
	private JTextField textField_452;
	private JTextField textField_453;
	private JTextField textField_434;
	private JTextField textField_435;
	private JTextField textField_436;
	private JTextField textField_444;
	private JTextField textField_445;
	private JTextField textField_446;
	private JTextField textField_454;
	private JTextField textField_455;
	private JTextField textField_456;
	private JTextField textField_437;
	private JTextField textField_438;
	private JTextField textField_439;
	private JTextField textField_447;
	private JTextField textField_448;
	private JTextField textField_449;
	private JTextField textField_457;
	private JTextField textField_458;
	private JTextField textField_459;
	private JTextField textField_521;
	private JTextField textField_522;
	private JTextField textField_523;
	private JTextField textField_531;
	private JTextField textField_532;
	private JTextField textField_533;
	private JTextField textField_541;
	private JTextField textField_542;
	private JTextField textField_543;
	private JTextField textField_524;
	private JTextField textField_525;
	private JTextField textField_526;
	private JTextField textField_534;
	private JTextField textField_535;
	private JTextField textField_536;
	private JTextField textField_544;
	private JTextField textField_545;
	private JTextField textField_546;
	private JTextField textField_527;
	private JTextField textField_528;
	private JTextField textField_529;
	private JTextField textField_537;
	private JTextField textField_538;
	private JTextField textField_539;
	private JTextField textField_547;
	private JTextField textField_548;
	private JTextField textField_549;
	private JTextField textField_551;
	private JTextField textField_552;
	private JTextField textField_553;
	private JTextField textField_561;
	private JTextField textField_562;
	private JTextField textField_563;
	private JTextField textField_571;
	private JTextField textField_572;
	private JTextField textField_573;
	private JTextField textField_554;
	private JTextField textField_555;
	private JTextField textField_556;
	private JTextField textField_564;
	private JTextField textField_565;
	private JTextField textField_566;
	private JTextField textField_574;
	private JTextField textField_575;
	private JTextField textField_576;
	private JTextField textField_557;
	private JTextField textField_558;
	private JTextField textField_559;
	private JTextField textField_567;
	private JTextField textField_568;
	private JTextField textField_569;
	private JTextField textField_577;
	private JTextField textField_579;
	private JTextField textField_578;
	private JTextField textField_641;
	private JTextField textField_642;
	private JTextField textField_643;
	private JTextField textField_651;
	private JTextField textField_652;
	private JTextField textField_653;
	private JTextField textField_661;
	private JTextField textField_662;
	private JTextField textField_663;
	private JTextField textField_644;
	private JTextField textField_645;
	private JTextField textField_646;
	private JTextField textField_654;
	private JTextField textField_655;
	private JTextField textField_656;
	private JTextField textField_664;
	private JTextField textField_665;
	private JTextField textField_666;
	private JTextField textField_647;
	private JTextField textField_648;
	private JTextField textField_649;
	private JTextField textField_657;
	private JTextField textField_658;
	private JTextField textField_659;
	private JTextField textField_667;
	private JTextField textField_668;
	private JTextField textField_669;
	private JTextField textField_731;
	private JTextField textField_732;
	private JTextField textField_733;
	private JTextField textField_741;
	private JTextField textField_742;
	private JTextField textField_743;
	private JTextField textField_751;
	private JTextField textField_752;
	private JTextField textField_753;
	private JTextField textField_734;
	private JTextField textField_735;
	private JTextField textField_736;
	private JTextField textField_744;
	private JTextField textField_745;
	private JTextField textField_746;
	private JTextField textField_754;
	private JTextField textField_755;
	private JTextField textField_756;
	private JTextField textField_737;
	private JTextField textField_738;
	private JTextField textField_739;
	private JTextField textField_747;
	private JTextField textField_748;
	private JTextField textField_749;
	private JTextField textField_757;
	private JTextField textField_758;
	private JTextField textField_759;
	private JTextField textField_581;
	private JTextField textField_582;
	private JTextField textField_583;
	private JTextField textField_591;
	private JTextField textField_592;
	private JTextField textField_593;
	private JTextField textField_601;
	private JTextField textField_602;
	private JTextField textField_603;
	private JTextField textField_584;
	private JTextField textField_585;
	private JTextField textField_586;
	private JTextField textField_594;
	private JTextField textField_595;
	private JTextField textField_596;
	private JTextField textField_604;
	private JTextField textField_605;
	private JTextField textField_606;
	private JTextField textField_587;
	private JTextField textField_588;
	private JTextField textField_589;
	private JTextField textField_597;
	private JTextField textField_598;
	private JTextField textField_599;
	private JTextField textField_607;
	private JTextField textField_609;
	private JTextField textField_608;
	private JTextField textField_671;
	private JTextField textField_672;
	private JTextField textField_673;
	private JTextField textField_681;
	private JTextField textField_682;
	private JTextField textField_683;
	private JTextField textField_691;
	private JTextField textField_692;
	private JTextField textField_693;
	private JTextField textField_674;
	private JTextField textField_675;
	private JTextField textField_676;
	private JTextField textField_684;
	private JTextField textField_685;
	private JTextField textField_686;
	private JTextField textField_694;
	private JTextField textField_695;
	private JTextField textField_696;
	private JTextField textField_677;
	private JTextField textField_678;
	private JTextField textField_679;
	private JTextField textField_687;
	private JTextField textField_688;
	private JTextField textField_689;
	private JTextField textField_697;
	private JTextField textField_698;
	private JTextField textField_699;
	private JTextField textField_761;
	private JTextField textField_762;
	private JTextField textField_763;
	private JTextField textField_771;
	private JTextField textField_772;
	private JTextField textField_773;
	private JTextField textField_781;
	private JTextField textField_782;
	private JTextField textField_783;
	private JTextField textField_764;
	private JTextField textField_765;
	private JTextField textField_766;
	private JTextField textField_774;
	private JTextField textField_775;
	private JTextField textField_776;
	private JTextField textField_784;
	private JTextField textField_785;
	private JTextField textField_786;
	private JTextField textField_767;
	private JTextField textField_768;
	private JTextField textField_769;
	private JTextField textField_777;
	private JTextField textField_778;
	private JTextField textField_779;
	private JTextField textField_787;
	private JTextField textField_788;
	private JTextField textField_789;
	private JTextField textField_611;
	private JTextField textField_612;
	private JTextField textField_613;
	private JTextField textField_621;
	private JTextField textField_622;
	private JTextField textField_623;
	private JTextField textField_631;
	private JTextField textField_632;
	private JTextField textField_633;
	private JTextField textField_614;
	private JTextField textField_615;
	private JTextField textField_616;
	private JTextField textField_624;
	private JTextField textField_625;
	private JTextField textField_626;
	private JTextField textField_634;
	private JTextField textField_635;
	private JTextField textField_636;
	private JTextField textField_617;
	private JTextField textField_618;
	private JTextField textField_619;
	private JTextField textField_627;
	private JTextField textField_628;
	private JTextField textField_629;
	private JTextField textField_637;
	private JTextField textField_639;
	private JTextField textField_638;
	private JTextField textField_701;
	private JTextField textField_702;
	private JTextField textField_703;
	private JTextField textField_711;
	private JTextField textField_712;
	private JTextField textField_713;
	private JTextField textField_721;
	private JTextField textField_722;
	private JTextField textField_723;
	private JTextField textField_704;
	private JTextField textField_705;
	private JTextField textField_706;
	private JTextField textField_714;
	private JTextField textField_715;
	private JTextField textField_716;
	private JTextField textField_724;
	private JTextField textField_725;
	private JTextField textField_726;
	private JTextField textField_707;
	private JTextField textField_708;
	private JTextField textField_709;
	private JTextField textField_717;
	private JTextField textField_718;
	private JTextField textField_719;
	private JTextField textField_727;
	private JTextField textField_728;
	private JTextField textField_729;
	private JTextField textField_791;
	private JTextField textField_792;
	private JTextField textField_793;
	private JTextField textField_801;
	private JTextField textField_802;
	private JTextField textField_803;
	private JTextField textField_811;
	private JTextField textField_812;
	private JTextField textField_813;
	private JTextField textField_794;
	private JTextField textField_795;
	private JTextField textField_796;
	private JTextField textField_804;
	private JTextField textField_805;
	private JTextField textField_806;
	private JTextField textField_814;
	private JTextField textField_815;
	private JTextField textField_816;
	private JTextField textField_797;
	private JTextField textField_798;
	private JTextField textField_799;
	private JTextField textField_807;
	private JTextField textField_808;
	private JTextField textField_809;
	private JTextField textField_817;
	private JTextField textField_818;
	private JTextField textField_819;
	private JTextField textField;

	public Grille() {
		setTitle ("Grille de Sudoku");
		setBounds(10, 20, 500, 700);
		addMouseListener(this);
		initComponents();
		initComponent2();
	}
	private void initComponents() {
		setForeground(Color.LIGHT_GRAY);
		setLayout(null);
		
		textField_11 = new JTextField();
		textField_11.setForeground(Color.LIGHT_GRAY);
		textField_11.addMouseListener(this);
		textField_11.setText("1");
		textField_11.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_11.setBounds(46, 31, 20, 20);
		add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setForeground(Color.LIGHT_GRAY);
		textField_12.addMouseListener(this);
		textField_12.addMouseListener(this);
		textField_12.setText("2");
		textField_12.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_12.setColumns(10);
		textField_12.setBounds(59, 31, 20, 20);
		
		add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setForeground(Color.LIGHT_GRAY);
		textField_13.addMouseListener(this);
		textField_13.setText("3");
		textField_13.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_13.setColumns(10);
		textField_13.setBounds(72, 31, 20, 20);
		textField_13.addMouseListener(this);
		add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setForeground(Color.LIGHT_GRAY);
		textField_14.addMouseListener(this);
		textField_14.setText("4");
		textField_14.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_14.setColumns(10);
		textField_14.setBounds(46, 46, 20, 20);
		add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setForeground(Color.LIGHT_GRAY);
		textField_15.addMouseListener(this);
		textField_15.setText("5");
		textField_15.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_15.setColumns(10);
		textField_15.setBounds(59, 46, 20, 20);
	
		add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setForeground(Color.LIGHT_GRAY);
		textField_16.addMouseListener(this);
		textField_16.setText("6");
		textField_16.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_16.setColumns(10);
		textField_16.setBounds(72, 46, 20, 20);
		add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setForeground(Color.LIGHT_GRAY);
		textField_17.addMouseListener(this);
		textField_17.setText("7");
		textField_17.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_17.setColumns(10);
		textField_17.setBounds(46, 61, 20, 20);
		add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setForeground(Color.LIGHT_GRAY);
		textField_18.addMouseListener(this);
		textField_18.setText("8");
		textField_18.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_18.setColumns(10);
		textField_18.setBounds(59, 61, 20, 20);
		add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setForeground(Color.LIGHT_GRAY);
		textField_19.addMouseListener(this);
		textField_19.setText("9");
		textField_19.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_19.setColumns(10);
		textField_19.setBounds(72, 61, 20, 20);
		add(textField_19);
		
		textField_21 = new JTextField();
		textField_21.setForeground(Color.LIGHT_GRAY);
		textField_21.addMouseListener(this);
		textField_21.setText("1");
		textField_21.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_21.setColumns(10);
		textField_21.setBounds(88, 31, 20, 20);
		add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setForeground(Color.LIGHT_GRAY);
		textField_22.addMouseListener(this);
		textField_22.setText("2");
		textField_22.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_22.setColumns(10);
		textField_22.setBounds(101, 31, 20, 20);
		add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setForeground(Color.LIGHT_GRAY);
		textField_23.addMouseListener(this);
		textField_23.setText("3");
		textField_23.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_23.setColumns(10);
		textField_23.setBounds(114, 31, 20, 20);
		add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setForeground(Color.LIGHT_GRAY);
		textField_24.addMouseListener(this);
		textField_24.setText("4");
		textField_24.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_24.setColumns(10);
		textField_24.setBounds(88, 46, 20, 20);
		add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setForeground(Color.LIGHT_GRAY);
		textField_25.addMouseListener(this);
		textField_25.setText("5");
		textField_25.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_25.setColumns(10);
		textField_25.setBounds(101, 46, 20, 20);
		add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setForeground(Color.LIGHT_GRAY);
		textField_26.addMouseListener(this);
		textField_26.setText("6");
		textField_26.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_26.setColumns(10);
		textField_26.setBounds(114, 46, 20, 20);
		add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setForeground(Color.LIGHT_GRAY);
		textField_27.addMouseListener(this);
		textField_27.setText("7");
		textField_27.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_27.setColumns(10);
		textField_27.setBounds(88, 61, 20, 20);
		add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setForeground(Color.LIGHT_GRAY);
		textField_28.addMouseListener(this);
		textField_28.setText("8");
		textField_28.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_28.setColumns(10);
		textField_28.setBounds(101, 61, 20, 20);
		add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setForeground(Color.LIGHT_GRAY);
		textField_29.addMouseListener(this);
		textField_29.setText("9");
		textField_29.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_29.setColumns(10);
		textField_29.setBounds(114, 61, 20, 20);
		add(textField_29);
		
		textField_31 = new JTextField();
		textField_31.setForeground(Color.LIGHT_GRAY);
		textField_31.addMouseListener(this);
		textField_31.setForeground(Color.LIGHT_GRAY);
		textField_31.addMouseListener(this);
		textField_31.setText("1");
		textField_31.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_31.setColumns(10);
		textField_31.setBounds(130, 31, 20, 20);
		add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setForeground(Color.LIGHT_GRAY);
		textField_32.addMouseListener(this);
		textField_32.setText("2");
		textField_32.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_32.setColumns(10);
		textField_32.setBounds(143, 31, 20, 20);
		add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setForeground(Color.LIGHT_GRAY);
		textField_33.addMouseListener(this);
		textField_33.setText("3");
		textField_33.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_33.setColumns(10);
		textField_33.setBounds(156, 31, 20, 20);
		add(textField_33);
		
		textField_39 = new JTextField();
		textField_39.setForeground(Color.LIGHT_GRAY);
		textField_39.addMouseListener(this);
		textField_39.setText("9");
		textField_39.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_39.setColumns(10);
		textField_39.setBounds(156, 61, 20, 20);
		add(textField_39);
		
		textField_36 = new JTextField();
		textField_36.setForeground(Color.LIGHT_GRAY);
		textField_36.addMouseListener(this);
		textField_36.setText("6");
		textField_36.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_36.setColumns(10);
		textField_36.setBounds(156, 46, 20, 20);
		add(textField_36);
		
		textField_35 = new JTextField();
		textField_35.setForeground(Color.LIGHT_GRAY);
		textField_35.addMouseListener(this);
		textField_35.setText("5");
		textField_35.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_35.setColumns(10);
		textField_35.setBounds(143, 46, 20, 20);
		add(textField_35);
		
		textField_34 = new JTextField();
		textField_34.setForeground(Color.LIGHT_GRAY);
		textField_34.addMouseListener(this);
		textField_34.setText("4");
		textField_34.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_34.setColumns(10);
		textField_34.setBounds(130, 46, 20, 20);
		add(textField_34);
		
		textField_38 = new JTextField();
		textField_38.setForeground(Color.LIGHT_GRAY);
		textField_38.addMouseListener(this);
		textField_38.setText("8");
		textField_38.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_38.setColumns(10);
		textField_38.setBounds(143, 61, 20, 20);
		add(textField_38);
		
		textField_37 = new JTextField();
		textField_37.setForeground(Color.LIGHT_GRAY);
		textField_37.addMouseListener(this);
		textField_37.setText("7");
		textField_37.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_37.setColumns(10);
		textField_37.setBounds(130, 61, 20, 20);
		add(textField_37);
		
		textField_101 = new JTextField();
		textField_101.setForeground(Color.LIGHT_GRAY);
		textField_101.addMouseListener(this);
		textField_101.setText("1");
		textField_101.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_101.setColumns(10);
		textField_101.setBounds(46, 79, 20, 20);
		add(textField_101);
		
		textField_102 = new JTextField();
		textField_102.setForeground(Color.LIGHT_GRAY);
		textField_102.addMouseListener(this);
		textField_102.setText("2");
		textField_102.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_102.setColumns(10);
		textField_102.setBounds(59, 79, 20, 20);
		add(textField_102);
		
		textField_103 = new JTextField();
		textField_103.setForeground(Color.LIGHT_GRAY);
		textField_103.addMouseListener(this);
		textField_103.setText("3");
		textField_103.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_103.setColumns(10);
		textField_103.setBounds(72, 79, 20, 20);
		add(textField_103);
		
		textField_104 = new JTextField();
		textField_104.setForeground(Color.LIGHT_GRAY);
		textField_104.addMouseListener(this);
		textField_104.setText("4");
		textField_104.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_104.setColumns(10);
		textField_104.setBounds(46, 94, 20, 20);
		add(textField_104);
		
		textField_105 = new JTextField();
		textField_105.setForeground(Color.LIGHT_GRAY);
		textField_105.addMouseListener(this);
		textField_105.setText("5");
		textField_105.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_105.setColumns(10);
		textField_105.setBounds(59, 94, 20, 20);
		add(textField_105);
		
		textField_106 = new JTextField();
		textField_106.setForeground(Color.LIGHT_GRAY);
		textField_106.addMouseListener(this);
		textField_106.setText("6");
		textField_106.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_106.setColumns(10);
		textField_106.setBounds(72, 94, 20, 20);
		add(textField_106);
		
		textField_107 = new JTextField();
		textField_107.setForeground(Color.LIGHT_GRAY);
		textField_107.addMouseListener(this);
		textField_107.setText("7");
		textField_107.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_107.setColumns(10);
		textField_107.setBounds(46, 109, 20, 20);
		add(textField_107);
		
		textField_108 = new JTextField();
		textField_108.setForeground(Color.LIGHT_GRAY);
		textField_108.addMouseListener(this);
		textField_108.setText("8");
		textField_108.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_108.setColumns(10);
		textField_108.setBounds(59, 109, 20, 20);
		add(textField_108);
		
		textField_109 = new JTextField();
		textField_109.setForeground(Color.LIGHT_GRAY);
		textField_109.addMouseListener(this);
		textField_109.setText("9");
		textField_109.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_109.setColumns(10);
		textField_109.setBounds(72, 109, 20, 20);
		add(textField_109);
		
		textField_111 = new JTextField();
		textField_111.setForeground(Color.LIGHT_GRAY);
		textField_111.addMouseListener(this);
		textField_111.setText("1");
		textField_111.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_111.setColumns(10);
		textField_111.setBounds(88, 79, 20, 20);
		add(textField_111);
		
		textField_112 = new JTextField();
		textField_112.setForeground(Color.LIGHT_GRAY);
		textField_112.addMouseListener(this);
		textField_112.setText("2");
		textField_112.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_112.setColumns(10);
		textField_112.setBounds(101, 79, 20, 20);
		add(textField_112);
		
		textField_113 = new JTextField();
		textField_113.setForeground(Color.LIGHT_GRAY);
		textField_113.addMouseListener(this);
		textField_113.setText("3");
		textField_113.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_113.setColumns(10);
		textField_113.setBounds(114, 79, 20, 20);
		add(textField_113);
		
		textField_114 = new JTextField();
		textField_114.setForeground(Color.LIGHT_GRAY);
		textField_114.addMouseListener(this);
		textField_114.setText("4");
		textField_114.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_114.setColumns(10);
		textField_114.setBounds(88, 94, 20, 20);
		add(textField_114);
		
		textField_115 = new JTextField();
		textField_115.setForeground(Color.LIGHT_GRAY);
		textField_115.addMouseListener(this);
		textField_115.setText("5");
		textField_115.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_115.setColumns(10);
		textField_115.setBounds(101, 94, 20, 20);
		add(textField_115);
		
		textField_116 = new JTextField();
		textField_116.setForeground(Color.LIGHT_GRAY);
		textField_116.addMouseListener(this);
		textField_116.setText("6");
		textField_116.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_116.setColumns(10);
		textField_116.setBounds(114, 94, 20, 20);
		add(textField_116);
		
		textField_117 = new JTextField();
		textField_117.setForeground(Color.LIGHT_GRAY);
		textField_117.addMouseListener(this);
		textField_117.setText("7");
		textField_117.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_117.setColumns(10);
		textField_117.setBounds(88, 109, 20, 20);
		add(textField_117);
		
		textField_118 = new JTextField();
		textField_118.setForeground(Color.LIGHT_GRAY);
		textField_118.addMouseListener(this);
		textField_118.setText("8");
		textField_118.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_118.setColumns(10);
		textField_118.setBounds(101, 109, 20, 20);
		add(textField_118);
		
		textField_119 = new JTextField();
		textField_119.setForeground(Color.LIGHT_GRAY);
		textField_119.addMouseListener(this);
		textField_119.setText("9");
		textField_119.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_119.setColumns(10);
		textField_119.setBounds(114, 109, 20, 20);
		add(textField_119);
		
		textField_121 = new JTextField();
		textField_121.setForeground(Color.LIGHT_GRAY);
		textField_121.addMouseListener(this);
		textField_121.setText("1");
		textField_121.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_121.setColumns(10);
		textField_121.setBounds(130, 79, 20, 20);
		add(textField_121);
		
		textField_122 = new JTextField();
		textField_122.setForeground(Color.LIGHT_GRAY);
		textField_122.addMouseListener(this);
		textField_122.setText("2");
		textField_122.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_122.setColumns(10);
		textField_122.setBounds(143, 79, 20, 20);
		add(textField_122);
		
		textField_123 = new JTextField();
		textField_123.setForeground(Color.LIGHT_GRAY);
		textField_123.addMouseListener(this);
		textField_123.setText("3");
		textField_123.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_123.setColumns(10);
		textField_123.setBounds(156, 79, 20, 20);
		add(textField_123);
		
		textField_124 = new JTextField();
		textField_124.setForeground(Color.LIGHT_GRAY);
		textField_124.addMouseListener(this);
		textField_124.setText("4");
		textField_124.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_124.setColumns(10);
		textField_124.setBounds(130, 94, 20, 20);
		add(textField_124);
		
		textField_125 = new JTextField();
		textField_125.setForeground(Color.LIGHT_GRAY);
		textField_125.addMouseListener(this);
		textField_125.setText("5");
		textField_125.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_125.setColumns(10);
		textField_125.setBounds(143, 94, 20, 20);
		add(textField_125);
		
		textField_126 = new JTextField();
		textField_126.setForeground(Color.LIGHT_GRAY);
		textField_126.addMouseListener(this);
		textField_126.setText("6");
		textField_126.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_126.setColumns(10);
		textField_126.setBounds(156, 94, 20, 20);
		add(textField_126);
		
		textField_127 = new JTextField();
		textField_127.setForeground(Color.LIGHT_GRAY);
		textField_127.addMouseListener(this);
		textField_127.setText("7");
		textField_127.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_127.setColumns(10);
		textField_127.setBounds(130, 109, 20, 20);
		add(textField_127);
		
		textField_128 = new JTextField();
		textField_128.setForeground(Color.LIGHT_GRAY);
		textField_128.addMouseListener(this);
		textField_128.setText("8");
		textField_128.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_128.setColumns(10);
		textField_128.setBounds(143, 109, 20, 20);
		add(textField_128);
		
		textField_129 = new JTextField();
		textField_129.setForeground(Color.LIGHT_GRAY);
		textField_129.addMouseListener(this);
		textField_129.setText("9");
		textField_129.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_129.setColumns(10);
		textField_129.setBounds(156, 109, 20, 20);
		add(textField_129);
		
		textField_191 = new JTextField();
		textField_191.setForeground(Color.LIGHT_GRAY);
		textField_191.addMouseListener(this);
		textField_191.setText("1");
		textField_191.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_191.setColumns(10);
		textField_191.setBounds(46, 127, 20, 20);
		add(textField_191);
		
		textField_192 = new JTextField();
		textField_192.setForeground(Color.LIGHT_GRAY);
		textField_192.addMouseListener(this);
		textField_192.setText("2");
		textField_192.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_192.setColumns(10);
		textField_192.setBounds(59, 127, 20, 20);
		add(textField_192);
		
		textField_193 = new JTextField();
		textField_193.setForeground(Color.LIGHT_GRAY);
		textField_193.addMouseListener(this);
		textField_193.setText("3");
		textField_193.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_193.setColumns(10);
		textField_193.setBounds(72, 127, 20, 20);
		add(textField_193);
		
		textField_194 = new JTextField();
		textField_194.setForeground(Color.LIGHT_GRAY);
		textField_194.addMouseListener(this);
		textField_194.setText("4");
		textField_194.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_194.setColumns(10);
		textField_194.setBounds(46, 142, 20, 20);
		add(textField_194);
		
		textField_195 = new JTextField();
		textField_195.setForeground(Color.LIGHT_GRAY);
		textField_195.addMouseListener(this);
		textField_195.setText("5");
		textField_195.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_195.setColumns(10);
		textField_195.setBounds(59, 142, 20, 20);
		add(textField_195);
		
		textField_196 = new JTextField();
		textField_196.setForeground(Color.LIGHT_GRAY);
		textField_196.addMouseListener(this);
		textField_196.setText("6");
		textField_196.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_196.setColumns(10);
		textField_196.setBounds(72, 142, 20, 20);
		add(textField_196);
		
		textField_197 = new JTextField();
		textField_197.setForeground(Color.LIGHT_GRAY);
		textField_197.addMouseListener(this);
		textField_197.setText("7");
		textField_197.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_197.setColumns(10);
		textField_197.setBounds(46, 157, 20, 20);
		add(textField_197);
		
		textField_198 = new JTextField();
		textField_198.setForeground(Color.LIGHT_GRAY);
		textField_198.addMouseListener(this);
		textField_198.setText("8");
		textField_198.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_198.setColumns(10);
		textField_198.setBounds(59, 157, 20, 20);
		add(textField_198);
		
		textField_199 = new JTextField();
		textField_199.setForeground(Color.LIGHT_GRAY);
		textField_199.addMouseListener(this);
		textField_199.setText("9");
		textField_199.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_199.setColumns(10);
		textField_199.setBounds(72, 157, 20, 20);
		add(textField_199);
		
		textField_201 = new JTextField();
		textField_201.setForeground(Color.LIGHT_GRAY);
		textField_201.addMouseListener(this);
		textField_201.setText("1");
		textField_201.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_201.setColumns(10);
		textField_201.setBounds(88, 127, 20, 20);
		add(textField_201);
		
		textField_202 = new JTextField();
		textField_202.setForeground(Color.LIGHT_GRAY);
		textField_202.addMouseListener(this);
		textField_202.setText("2");
		textField_202.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_202.setColumns(10);
		textField_202.setBounds(101, 127, 20, 20);
		add(textField_202);
		
		textField_203 = new JTextField();
		textField_203.setForeground(Color.LIGHT_GRAY);
		textField_203.addMouseListener(this);
		textField_203.setText("3");
		textField_203.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_203.setColumns(10);
		textField_203.setBounds(114, 127, 20, 20);
		add(textField_203);
		
		textField_204 = new JTextField();
		textField_204.setForeground(Color.LIGHT_GRAY);
		textField_204.addMouseListener(this);
		textField_204.setText("4");
		textField_204.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_204.setColumns(10);
		textField_204.setBounds(88, 142, 20, 20);
		add(textField_204);
		
		textField_205 = new JTextField();
		textField_205.setForeground(Color.LIGHT_GRAY);
		textField_205.addMouseListener(this);
		textField_205.setText("5");
		textField_205.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_205.setColumns(10);
		textField_205.setBounds(101, 142, 20, 20);
		add(textField_205);
		
		textField_206 = new JTextField();
		textField_206.setForeground(Color.LIGHT_GRAY);
		textField_206.addMouseListener(this);
		textField_206.setText("6");
		textField_206.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_206.setColumns(10);
		textField_206.setBounds(114, 142, 20, 20);
		add(textField_206);
		
		textField_207 = new JTextField();
		textField_207.setForeground(Color.LIGHT_GRAY);
		textField_207.addMouseListener(this);
		textField_207.setText("7");
		textField_207.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_207.setColumns(10);
		textField_207.setBounds(88, 157, 20, 20);
		add(textField_207);
		
		textField_208 = new JTextField();
		textField_208.setForeground(Color.LIGHT_GRAY);
		textField_208.addMouseListener(this);
		textField_208.setText("8");
		textField_208.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_208.setColumns(10);
		textField_208.setBounds(101, 157, 20, 20);
		add(textField_208);
		
		textField_209 = new JTextField();
		textField_209.setForeground(Color.LIGHT_GRAY);
		textField_209.addMouseListener(this);
		textField_209.setText("9");
		textField_209.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_209.setColumns(10);
		textField_209.setBounds(114, 157, 20, 20);
		add(textField_209);
		
		textField_211 = new JTextField();
		textField_211.setForeground(Color.LIGHT_GRAY);
		textField_211.addMouseListener(this);
		textField_211.setText("1");
		textField_211.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_211.setColumns(10);
		textField_211.setBounds(130, 127, 20, 20);
		add(textField_211);
		
		textField_212 = new JTextField();
		textField_212.setForeground(Color.LIGHT_GRAY);
		textField_212.addMouseListener(this);
		textField_212.setText("2");
		textField_212.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_212.setColumns(10);
		textField_212.setBounds(143, 127, 20, 20);
		add(textField_212);
		
		textField_213 = new JTextField();
		textField_213.setForeground(Color.LIGHT_GRAY);
		textField_213.addMouseListener(this);
		textField_213.setText("3");
		textField_213.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_213.setColumns(10);
		textField_213.setBounds(156, 127, 20, 20);
		add(textField_213);
		
		textField_214 = new JTextField();
		textField_214.setForeground(Color.LIGHT_GRAY);
		textField_214.addMouseListener(this);
		textField_214.setText("4");
		textField_214.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_214.setColumns(10);
		textField_214.setBounds(130, 142, 20, 20);
		add(textField_214);
		
		textField_215 = new JTextField();
		textField_215.setForeground(Color.LIGHT_GRAY);
		textField_215.addMouseListener(this);
		textField_215.setText("5");
		textField_215.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_215.setColumns(10);
		textField_215.setBounds(143, 142, 20, 20);
		add(textField_215);
		
		textField_216 = new JTextField();
		textField_216.setForeground(Color.LIGHT_GRAY);
		textField_216.addMouseListener(this);
		textField_216.setText("6");
		textField_216.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_216.setColumns(10);
		textField_216.setBounds(156, 142, 20, 20);
		add(textField_216);
		
		textField_217 = new JTextField();
		textField_217.setForeground(Color.LIGHT_GRAY);
		textField_217.addMouseListener(this);
		textField_217.setText("7");
		textField_217.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_217.setColumns(10);
		textField_217.setBounds(130, 157, 20, 20);
		add(textField_217);
		
		textField_218 = new JTextField();
		textField_218.setForeground(Color.LIGHT_GRAY);
		textField_218.addMouseListener(this);
		textField_218.setText("8");
		textField_218.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_218.setColumns(10);
		textField_218.setBounds(143, 157, 20, 20);
		add(textField_218);
		
		textField_219 = new JTextField();
		textField_219.setForeground(Color.LIGHT_GRAY);
		textField_219.addMouseListener(this);
		textField_219.setText("9");
		textField_219.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_219.setColumns(10);
		textField_219.setBounds(156, 157, 20, 20);
		add(textField_219);
		
		textField_41 = new JTextField();
		textField_41.setForeground(Color.LIGHT_GRAY);
		textField_41.addMouseListener(this);
		textField_41.setText("1");
		textField_41.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_41.setColumns(10);
		textField_41.setBounds(175, 31, 20, 20);
		add(textField_41);
		
		textField_42 = new JTextField();
		textField_42.setForeground(Color.LIGHT_GRAY);
		textField_42.addMouseListener(this);
		textField_42.setText("2");
		textField_42.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_42.setColumns(10);
		textField_42.setBounds(188, 31, 20, 20);
		add(textField_42);
		
		textField_43 = new JTextField();
		textField_43.setForeground(Color.LIGHT_GRAY);
		textField_43.addMouseListener(this);
		textField_43.setText("3");
		textField_43.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_43.setColumns(10);
		textField_43.setBounds(201, 31, 20, 20);
		add(textField_43);
		
		textField_51 = new JTextField();
		textField_51.setForeground(Color.LIGHT_GRAY);
		textField_51.addMouseListener(this);
		textField_51.setText("1");
		textField_51.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_51.setColumns(10);
		textField_51.setBounds(217, 31, 20, 20);
		add(textField_51);
		
		textField_52 = new JTextField();
		textField_52.setForeground(Color.LIGHT_GRAY);
		textField_52.addMouseListener(this);
		textField_52.setText("2");
		textField_52.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_52.setColumns(10);
		textField_52.setBounds(230, 31, 20, 20);
		add(textField_52);
		
		textField_53 = new JTextField();
		textField_53.setForeground(Color.LIGHT_GRAY);
		textField_53.addMouseListener(this);
		textField_53.setText("3");
		textField_53.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_53.setColumns(10);
		textField_53.setBounds(243, 31, 20, 20);
		add(textField_53);
		
		textField_61 = new JTextField();
		textField_61.setForeground(Color.LIGHT_GRAY);
		textField_61.addMouseListener(this);
		textField_61.setText("1");
		textField_61.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_61.setColumns(10);
		textField_61.setBounds(259, 31, 20, 20);
		add(textField_61);
		
		textField_62 = new JTextField();
		textField_62.setForeground(Color.LIGHT_GRAY);
		textField_62.addMouseListener(this);
		textField_62.setText("2");
		textField_62.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_62.setColumns(10);
		textField_62.setBounds(272, 31, 20, 20);
		add(textField_62);
		
		textField_63 = new JTextField();
		textField_63.setForeground(Color.LIGHT_GRAY);
		textField_63.addMouseListener(this);
		textField_63.setText("3");
		textField_63.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_63.setColumns(10);
		textField_63.setBounds(285, 31, 20, 20);
		add(textField_63);
		
		textField_44 = new JTextField();
		textField_44.setForeground(Color.LIGHT_GRAY);
		textField_44.addMouseListener(this);
		textField_44.setText("4");
		textField_44.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_44.setColumns(10);
		textField_44.setBounds(175, 46, 20, 20);
		add(textField_44);
		
		textField_45 = new JTextField();
		textField_45.setForeground(Color.LIGHT_GRAY);
		textField_45.addMouseListener(this);
		textField_45.setText("5");
		textField_45.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_45.setColumns(10);
		textField_45.setBounds(188, 46, 20, 20);
		add(textField_45);
		
		textField_46 = new JTextField();
		textField_46.setForeground(Color.LIGHT_GRAY);
		textField_46.addMouseListener(this);
		textField_46.setText("6");
		textField_46.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_46.setColumns(10);
		textField_46.setBounds(201, 46, 20, 20);
		add(textField_46);
		
		textField_54 = new JTextField();
		textField_54.setForeground(Color.LIGHT_GRAY);
		textField_54.addMouseListener(this);
		textField_54.setText("4");
		textField_54.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_54.setColumns(10);
		textField_54.setBounds(217, 46, 20, 20);
		add(textField_54);
		
		textField_55 = new JTextField();
		textField_55.setForeground(Color.LIGHT_GRAY);
		textField_55.addMouseListener(this);
		textField_55.setText("5");
		textField_55.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_55.setColumns(10);
		textField_55.setBounds(230, 46, 20, 20);
		add(textField_55);
		
		textField_56 = new JTextField();
		textField_56.setForeground(Color.LIGHT_GRAY);
		textField_56.addMouseListener(this);
		textField_56.setText("6");
		textField_56.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_56.setColumns(10);
		textField_56.setBounds(243, 46, 20, 20);
		add(textField_56);
		
		textField_64 = new JTextField();
		textField_64.setForeground(Color.LIGHT_GRAY);
		textField_64.addMouseListener(this);
		textField_64.setText("4");
		textField_64.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_64.setColumns(10);
		textField_64.setBounds(259, 46, 20, 20);
		add(textField_64);
		
		textField_65 = new JTextField();
		textField_65.setForeground(Color.LIGHT_GRAY);
		textField_65.addMouseListener(this);
		textField_65.setText("5");
		textField_65.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_65.setColumns(10);
		textField_65.setBounds(272, 46, 20, 20);
		add(textField_65);
		
		textField_66 = new JTextField();
		textField_66.setForeground(Color.LIGHT_GRAY);
		textField_66.addMouseListener(this);
		textField_66.setText("6");
		textField_66.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_66.setColumns(10);
		textField_66.setBounds(285, 46, 20, 20);
		add(textField_66);
		
		textField_47 = new JTextField();
		textField_47.setForeground(Color.LIGHT_GRAY);
		textField_47.addMouseListener(this);
		textField_47.setText("7");
		textField_47.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_47.setColumns(10);
		textField_47.setBounds(175, 61, 20, 20);
		add(textField_47);
		
		textField_48 = new JTextField();
		textField_48.setForeground(Color.LIGHT_GRAY);
		textField_48.addMouseListener(this);
		textField_48.setText("8");
		textField_48.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_48.setColumns(10);
		textField_48.setBounds(188, 61, 20, 20);
		add(textField_48);
		
		textField_49 = new JTextField();
		textField_49.setForeground(Color.LIGHT_GRAY);
		textField_49.addMouseListener(this);
		textField_49.setText("9");
		textField_49.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_49.setColumns(10);
		textField_49.setBounds(201, 61, 20, 20);
		add(textField_49);
		
		textField_57 = new JTextField();
		textField_57.setForeground(Color.LIGHT_GRAY);
		textField_57.addMouseListener(this);
		textField_57.setText("7");
		textField_57.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_57.setColumns(10);
		textField_57.setBounds(217, 61, 20, 20);
		add(textField_57);
		
		textField_58 = new JTextField();
		textField_58.setForeground(Color.LIGHT_GRAY);
		textField_58.addMouseListener(this);
		textField_58.setText("8");
		textField_58.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_58.setColumns(10);
		textField_58.setBounds(230, 61, 20, 20);
		add(textField_58);
		
		textField_59 = new JTextField();
		textField_59.setForeground(Color.LIGHT_GRAY);
		textField_59.addMouseListener(this);
		textField_59.setText("9");
		textField_59.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_59.setColumns(10);
		textField_59.setBounds(243, 61, 20, 20);
		add(textField_59);
		
		textField_67 = new JTextField();
		textField_67.setForeground(Color.LIGHT_GRAY);
		textField_67.addMouseListener(this);
		textField_67.setText("7");
		textField_67.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_67.setColumns(10);
		textField_67.setBounds(259, 61, 20, 20);
		add(textField_67);
		
		textField_69 = new JTextField();
		textField_69.setForeground(Color.LIGHT_GRAY);
		textField_69.addMouseListener(this);
		textField_69.setText("9");
		textField_69.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_69.setColumns(10);
		textField_69.setBounds(285, 61, 20, 20);
		add(textField_69);
		
		textField_68 = new JTextField();
		textField_68.setForeground(Color.LIGHT_GRAY);
		textField_68.addMouseListener(this);
		textField_68.setText("8");
		textField_68.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_68.setColumns(10);
		textField_68.setBounds(272, 61, 20, 20);
		add(textField_68);
		
		textField_131 = new JTextField();
		textField_131.setForeground(Color.LIGHT_GRAY);
		textField_131.addMouseListener(this);
		textField_131.setForeground(Color.LIGHT_GRAY);
		textField_131.addMouseListener(this);
		textField_131.setText("1");
		textField_131.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_131.setColumns(10);
		textField_131.setBounds(175, 79, 20, 20);
		add(textField_131);
		
		textField_132 = new JTextField();
		textField_132.setForeground(Color.LIGHT_GRAY);
		textField_132.addMouseListener(this);
		textField_132.setText("2");
		textField_132.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_132.setColumns(10);
		textField_132.setBounds(188, 79, 20, 20);
		add(textField_132);
		
		textField_133 = new JTextField();
		textField_133.setForeground(Color.LIGHT_GRAY);
		textField_133.addMouseListener(this);
		textField_133.setText("3");
		textField_133.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_133.setColumns(10);
		textField_133.setBounds(201, 79, 20, 20);
		add(textField_133);
		
		textField_141 = new JTextField();
		textField_141.setForeground(Color.LIGHT_GRAY);
		textField_141.addMouseListener(this);
		textField_141.setText("1");
		textField_141.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_141.setColumns(10);
		textField_141.setBounds(217, 79, 20, 20);
		add(textField_141);
		
		textField_142 = new JTextField();
		textField_142.setForeground(Color.LIGHT_GRAY);
		textField_142.addMouseListener(this);
		textField_142.setText("2");
		textField_142.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_142.setColumns(10);
		textField_142.setBounds(230, 79, 20, 20);
		add(textField_142);
		
		textField_143 = new JTextField();
		textField_143.setForeground(Color.LIGHT_GRAY);
		textField_143.addMouseListener(this);
		textField_143.setText("3");
		textField_143.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_143.setColumns(10);
		textField_143.setBounds(243, 79, 20, 20);
		add(textField_143);
		
		textField_151 = new JTextField();
		textField_151.setForeground(Color.LIGHT_GRAY);
		textField_151.addMouseListener(this);
		textField_151.setText("1");
		textField_151.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_151.setColumns(10);
		textField_151.setBounds(259, 79, 20, 20);
		add(textField_151);
		
		textField_152 = new JTextField();
		textField_152.setForeground(Color.LIGHT_GRAY);
		textField_152.addMouseListener(this);
		textField_152.setText("2");
		textField_152.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_152.setColumns(10);
		textField_152.setBounds(272, 79, 20, 20);
		add(textField_152);
		
		textField_153 = new JTextField();
		textField_153.setForeground(Color.LIGHT_GRAY);
		textField_153.addMouseListener(this);
		textField_153.setText("3");
		textField_153.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_153.setColumns(10);
		textField_153.setBounds(285, 79, 20, 20);
		add(textField_153);
		
		textField_134 = new JTextField();
		textField_134.setForeground(Color.LIGHT_GRAY);
		textField_134.addMouseListener(this);
		textField_134.setText("4");
		textField_134.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_134.setColumns(10);
		textField_134.setBounds(175, 94, 20, 20);
		add(textField_134);
		
		textField_135 = new JTextField();
		textField_135.setForeground(Color.LIGHT_GRAY);
		textField_135.addMouseListener(this);
		textField_135.setText("5");
		textField_135.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_135.setColumns(10);
		textField_135.setBounds(188, 94, 20, 20);
		add(textField_135);
		
		textField_136 = new JTextField();
		textField_136.setForeground(Color.LIGHT_GRAY);
		textField_136.addMouseListener(this);
		textField_136.setText("6");
		textField_136.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_136.setColumns(10);
		textField_136.setBounds(201, 94, 20, 20);
		add(textField_136);
		
		textField_144 = new JTextField();
		textField_144.setForeground(Color.LIGHT_GRAY);
		textField_144.addMouseListener(this);
		textField_144.setText("4");
		textField_144.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_144.setColumns(10);
		textField_144.setBounds(217, 94, 20, 20);
		add(textField_144);
		
		textField_145 = new JTextField();
		textField_145.setForeground(Color.LIGHT_GRAY);
		textField_145.addMouseListener(this);
		textField_145.setText("5");
		textField_145.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_145.setColumns(10);
		textField_145.setBounds(230, 94, 20, 20);
		add(textField_145);
		
		textField_146 = new JTextField();
		textField_146.setForeground(Color.LIGHT_GRAY);
		textField_146.addMouseListener(this);
		textField_146.setText("6");
		textField_146.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_146.setColumns(10);
		textField_146.setBounds(243, 94, 20, 20);
		add(textField_146);
		
		textField_154 = new JTextField();
		textField_154.setForeground(Color.LIGHT_GRAY);
		textField_154.addMouseListener(this);
		textField_154.setText("4");
		textField_154.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_154.setColumns(10);
		textField_154.setBounds(259, 94, 20, 20);
		add(textField_154);
		
		textField_155 = new JTextField();
		textField_155.setForeground(Color.LIGHT_GRAY);
		textField_155.addMouseListener(this);
		textField_155.setText("5");
		textField_155.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_155.setColumns(10);
		textField_155.setBounds(272, 94, 20, 20);
		add(textField_155);
		
		textField_156 = new JTextField();
		textField_156.setForeground(Color.LIGHT_GRAY);
		textField_156.addMouseListener(this);
		textField_156.setText("6");
		textField_156.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_156.setColumns(10);
		textField_156.setBounds(285, 94, 20, 20);
		add(textField_156);
		
		textField_137 = new JTextField();
		textField_137.setForeground(Color.LIGHT_GRAY);
		textField_137.addMouseListener(this);
		textField_137.setText("7");
		textField_137.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_137.setColumns(10);
		textField_137.setBounds(175, 109, 20, 20);
		add(textField_137);
		
		textField_138 = new JTextField();
		textField_138.setForeground(Color.LIGHT_GRAY);
		textField_138.addMouseListener(this);
		textField_138.setText("8");
		textField_138.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_138.setColumns(10);
		textField_138.setBounds(188, 109, 20, 20);
		add(textField_138);
		
		textField_139 = new JTextField();
		textField_139.setForeground(Color.LIGHT_GRAY);
		textField_139.addMouseListener(this);
		textField_139.setText("9");
		textField_139.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_139.setColumns(10);
		textField_139.setBounds(201, 109, 20, 20);
		add(textField_139);
		
		textField_147 = new JTextField();
		textField_147.setForeground(Color.LIGHT_GRAY);
		textField_147.addMouseListener(this);
		textField_147.setText("7");
		textField_147.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_147.setColumns(10);
		textField_147.setBounds(217, 109, 20, 20);
		add(textField_147);
		
		textField_148 = new JTextField();
		textField_148.setForeground(Color.LIGHT_GRAY);
		textField_148.addMouseListener(this);
		textField_148.setText("8");
		textField_148.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_148.setColumns(10);
		textField_148.setBounds(230, 109, 20, 20);
		add(textField_148);
		
		textField_149 = new JTextField();
		textField_149.setForeground(Color.LIGHT_GRAY);
		textField_149.addMouseListener(this);
		textField_149.setText("9");
		textField_149.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_149.setColumns(10);
		textField_149.setBounds(243, 109, 20, 20);
		add(textField_149);
		
		textField_157 = new JTextField();
		textField_157.setForeground(Color.LIGHT_GRAY);
		textField_157.addMouseListener(this);
		textField_157.setText("7");
		textField_157.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_157.setColumns(10);
		textField_157.setBounds(259, 109, 20, 20);
		add(textField_157);
		
		textField_158 = new JTextField();
		textField_158.setForeground(Color.LIGHT_GRAY);
		textField_158.addMouseListener(this);
		textField_158.setText("8");
		textField_158.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_158.setColumns(10);
		textField_158.setBounds(272, 109, 20, 20);
		add(textField_158);
		
		textField_159 = new JTextField();
		textField_159.setForeground(Color.LIGHT_GRAY);
		textField_159.addMouseListener(this);
		textField_159.setText("9");
		textField_159.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_159.setColumns(10);
		textField_159.setBounds(285, 109, 20, 20);
		add(textField_159);
		
		textField_221 = new JTextField();
		textField_221.setForeground(Color.LIGHT_GRAY);
		textField_221.addMouseListener(this);
		textField_221.setText("1");
		textField_221.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_221.setColumns(10);
		textField_221.setBounds(175, 127, 20, 20);
		add(textField_221);
		
		textField_222 = new JTextField();
		textField_222.setForeground(Color.LIGHT_GRAY);
		textField_222.addMouseListener(this);
		textField_222.setText("2");
		textField_222.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_222.setColumns(10);
		textField_222.setBounds(188, 127, 20, 20);
		add(textField_222);
		
		textField_223 = new JTextField();
		textField_223.setForeground(Color.LIGHT_GRAY);
		textField_223.addMouseListener(this);
		textField_223.setText("3");
		textField_223.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_223.setColumns(10);
		textField_223.setBounds(201, 127, 20, 20);
		add(textField_223);
		
		textField_231 = new JTextField();
		textField_231.setForeground(Color.LIGHT_GRAY);
		textField_231.addMouseListener(this);
		textField_231.setText("1");
		textField_231.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_231.setColumns(10);
		textField_231.setBounds(217, 127, 20, 20);
		add(textField_231);
		
		textField_232 = new JTextField();
		textField_232.setForeground(Color.LIGHT_GRAY);
		textField_232.addMouseListener(this);
		textField_232.setText("2");
		textField_232.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_232.setColumns(10);
		textField_232.setBounds(230, 127, 20, 20);
		add(textField_232);
		
		textField_233 = new JTextField();
		textField_233.setForeground(Color.LIGHT_GRAY);
		textField_233.addMouseListener(this);
		textField_233.setText("3");
		textField_233.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_233.setColumns(10);
		textField_233.setBounds(243, 127, 20, 20);
		add(textField_233);
		
		textField_241 = new JTextField();
		textField_241.setForeground(Color.LIGHT_GRAY);
		textField_241.addMouseListener(this);
		textField_241.setText("1");
		textField_241.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_241.setColumns(10);
		textField_241.setBounds(259, 127, 20, 20);
		add(textField_241);
		
		textField_242 = new JTextField();
		textField_242.setForeground(Color.LIGHT_GRAY);
		textField_242.addMouseListener(this);
		textField_242.setText("2");
		textField_242.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_242.setColumns(10);
		textField_242.setBounds(272, 127, 20, 20);
		add(textField_242);
		
		textField_243 = new JTextField();
		textField_243.setForeground(Color.LIGHT_GRAY);
		textField_243.addMouseListener(this);
		textField_243.setText("3");
		textField_243.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_243.setColumns(10);
		textField_243.setBounds(285, 127, 20, 20);
		add(textField_243);
		
		textField_224 = new JTextField();
		textField_224.setForeground(Color.LIGHT_GRAY);
		textField_224.addMouseListener(this);
		textField_224.setText("4");
		textField_224.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_224.setColumns(10);
		textField_224.setBounds(175, 142, 20, 20);
		add(textField_224);
		
		textField_225 = new JTextField();
		textField_225.setForeground(Color.LIGHT_GRAY);
		textField_225.addMouseListener(this);
		textField_225.setText("5");
		textField_225.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_225.setColumns(10);
		textField_225.setBounds(188, 142, 20, 20);
		add(textField_225);
		
		textField_226 = new JTextField();
		textField_226.setForeground(Color.LIGHT_GRAY);
		textField_226.addMouseListener(this);
		textField_226.setText("6");
		textField_226.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_226.setColumns(10);
		textField_226.setBounds(201, 142, 20, 20);
		add(textField_226);
		
		textField_234 = new JTextField();
		textField_234.setForeground(Color.LIGHT_GRAY);
		textField_234.addMouseListener(this);
		textField_234.setText("4");
		textField_234.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_234.setColumns(10);
		textField_234.setBounds(217, 142, 20, 20);
		add(textField_234);
		
		textField_235 = new JTextField();
		textField_235.setForeground(Color.LIGHT_GRAY);
		textField_235.addMouseListener(this);
		textField_235.setText("5");
		textField_235.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_235.setColumns(10);
		textField_235.setBounds(230, 142, 20, 20);
		add(textField_235);
		
		textField_236 = new JTextField();
		textField_236.setForeground(Color.LIGHT_GRAY);
		textField_236.addMouseListener(this);
		textField_236.setText("6");
		textField_236.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_236.setColumns(10);
		textField_236.setBounds(243, 142, 20, 20);
		add(textField_236);
		
		textField_244 = new JTextField();
		textField_244.setForeground(Color.LIGHT_GRAY);
		textField_244.addMouseListener(this);
		textField_244.setText("4");
		textField_244.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_244.setColumns(10);
		textField_244.setBounds(259, 142, 20, 20);
		add(textField_244);
		
		textField_245 = new JTextField();
		textField_245.setForeground(Color.LIGHT_GRAY);
		textField_245.addMouseListener(this);
		textField_245.setText("5");
		textField_245.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_245.setColumns(10);
		textField_245.setBounds(272, 142, 20, 20);
		add(textField_245);
		
		textField_246 = new JTextField();
		textField_246.setForeground(Color.LIGHT_GRAY);
		textField_246.addMouseListener(this);
		textField_246.setText("6");
		textField_246.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_246.setColumns(10);
		textField_246.setBounds(285, 142, 20, 20);
		add(textField_246);
		
		textField_227 = new JTextField();
		textField_227.setForeground(Color.LIGHT_GRAY);
		textField_227.addMouseListener(this);
		textField_227.setText("7");
		textField_227.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_227.setColumns(10);
		textField_227.setBounds(175, 157, 20, 20);
		add(textField_227);
		
		textField_228 = new JTextField();
		textField_228.setForeground(Color.LIGHT_GRAY);
		textField_228.addMouseListener(this);
		textField_228.setText("8");
		textField_228.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_228.setColumns(10);
		textField_228.setBounds(188, 157, 20, 20);
		add(textField_228);
		
		textField_229 = new JTextField();
		textField_229.setForeground(Color.LIGHT_GRAY);
		textField_229.addMouseListener(this);
		textField_229.setText("9");
		textField_229.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_229.setColumns(10);
		textField_229.setBounds(201, 157, 20, 20);
		add(textField_229);
		
		textField_237 = new JTextField();
		textField_237.setForeground(Color.LIGHT_GRAY);
		textField_237.addMouseListener(this);
		textField_237.setText("7");
		textField_237.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_237.setColumns(10);
		textField_237.setBounds(217, 157, 20, 20);
		add(textField_237);
		
		textField_238 = new JTextField();
		textField_238.setForeground(Color.LIGHT_GRAY);
		textField_238.addMouseListener(this);
		textField_238.setText("8");
		textField_238.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_238.setColumns(10);
		textField_238.setBounds(230, 157, 20, 20);
		add(textField_238);
		
		textField_239 = new JTextField();
		textField_239.setForeground(Color.LIGHT_GRAY);
		textField_239.addMouseListener(this);
		textField_239.setText("9");
		textField_239.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_239.setColumns(10);
		textField_239.setBounds(243, 157, 20, 20);
		add(textField_239);
		
		textField_247 = new JTextField();
		textField_247.setForeground(Color.LIGHT_GRAY);
		textField_247.addMouseListener(this);
		textField_247.setText("7");
		textField_247.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_247.setColumns(10);
		textField_247.setBounds(259, 157, 20, 20);
		add(textField_247);
		
		textField_248 = new JTextField();
		textField_248.setForeground(Color.LIGHT_GRAY);
		textField_248.addMouseListener(this);
		textField_248.setText("8");
		textField_248.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_248.setColumns(10);
		textField_248.setBounds(272, 157, 20, 20);
		add(textField_248);
		
		textField_249 = new JTextField();
		textField_249.setForeground(Color.LIGHT_GRAY);
		textField_249.addMouseListener(this);
		textField_249.setText("9");
		textField_249.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_249.setColumns(10);
		textField_249.setBounds(285, 157, 20, 20);
		add(textField_249);
		
		textField_71 = new JTextField();
		textField_71.setForeground(Color.LIGHT_GRAY);
		textField_71.addMouseListener(this);
		textField_71.setText("1");
		textField_71.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_71.setColumns(10);
		textField_71.setBounds(304, 31, 20, 20);
		add(textField_71);
		
		textField_72 = new JTextField();
		textField_72.setForeground(Color.LIGHT_GRAY);
		textField_72.addMouseListener(this);
		textField_72.setText("2");
		textField_72.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_72.setColumns(10);
		textField_72.setBounds(317, 31, 20, 20);
		add(textField_72);
		
		textField_73 = new JTextField();
		textField_73.setForeground(Color.LIGHT_GRAY);
		textField_73.addMouseListener(this);
		textField_73.setText("3");
		textField_73.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_73.setColumns(10);
		textField_73.setBounds(330, 31, 20, 20);
		add(textField_73);
		
		textField_81 = new JTextField();
		textField_81.setForeground(Color.LIGHT_GRAY);
		textField_81.addMouseListener(this);
		textField_81.setText("1");
		textField_81.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_81.setColumns(10);
		textField_81.setBounds(346, 31, 20, 20);
		add(textField_81);
		
		textField_82 = new JTextField();
		textField_82.setForeground(Color.LIGHT_GRAY);
		textField_82.addMouseListener(this);
		textField_82.setText("2");
		textField_82.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_82.setColumns(10);
		textField_82.setBounds(359, 31, 20, 20);
		add(textField_82);
		
		textField_83 = new JTextField();
		textField_83.setForeground(Color.LIGHT_GRAY);
		textField_83.addMouseListener(this);
		textField_83.setText("3");
		textField_83.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_83.setColumns(10);
		textField_83.setBounds(372, 31, 20, 20);
		add(textField_83);
		
		textField_91 = new JTextField();
		textField_91.setForeground(Color.LIGHT_GRAY);
		textField_91.addMouseListener(this);
		textField_91.setText("1");
		textField_91.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_91.setColumns(10);
		textField_91.setBounds(388, 31, 20, 20);
		add(textField_91);
		
		textField_92 = new JTextField();
		textField_92.setForeground(Color.LIGHT_GRAY);
		textField_92.addMouseListener(this);
		textField_92.setText("2");
		textField_92.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_92.setColumns(10);
		textField_92.setBounds(401, 31, 20, 20);
		add(textField_92);
		
		textField_93 = new JTextField();
		textField_93.setForeground(Color.LIGHT_GRAY);
		textField_93.addMouseListener(this);
		textField_93.setText("3");
		textField_93.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_93.setColumns(10);
		textField_93.setBounds(414, 31, 20, 20);
		add(textField_93);
		
		textField_74 = new JTextField();
		textField_74.setForeground(Color.LIGHT_GRAY);
		textField_74.addMouseListener(this);
		textField_74.setText("4");
		textField_74.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_74.setColumns(10);
		textField_74.setBounds(304, 46, 20, 20);
		add(textField_74);
		
		textField_75 = new JTextField();
		textField_75.setForeground(Color.LIGHT_GRAY);
		textField_75.addMouseListener(this);
		textField_75.setText("5");
		textField_75.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_75.setColumns(10);
		textField_75.setBounds(317, 46, 20, 20);
		add(textField_75);
		
		textField_76 = new JTextField();
		textField_76.setForeground(Color.LIGHT_GRAY);
		textField_76.addMouseListener(this);
		textField_76.setText("6");
		textField_76.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_76.setColumns(10);
		textField_76.setBounds(330, 46, 20, 20);
		add(textField_76);
		
		textField_84 = new JTextField();
		textField_84.setForeground(Color.LIGHT_GRAY);
		textField_84.addMouseListener(this);
		textField_84.setText("4");
		textField_84.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_84.setColumns(10);
		textField_84.setBounds(346, 46, 20, 20);
		add(textField_84);
		
		textField_85 = new JTextField();
		textField_85.setForeground(Color.LIGHT_GRAY);
		textField_85.addMouseListener(this);
		textField_85.setText("5");
		textField_85.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_85.setColumns(10);
		textField_85.setBounds(359, 46, 20, 20);
		add(textField_85);
		
		textField_86 = new JTextField();
		textField_86.setForeground(Color.LIGHT_GRAY);
		textField_86.addMouseListener(this);
		textField_86.setText("6");
		textField_86.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_86.setColumns(10);
		textField_86.setBounds(372, 46, 20, 20);
		add(textField_86);
		
		textField_94 = new JTextField();
		textField_94.setForeground(Color.LIGHT_GRAY);
		textField_94.addMouseListener(this);
		textField_94.setText("4");
		textField_94.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_94.setColumns(10);
		textField_94.setBounds(388, 46, 20, 20);
		add(textField_94);
		
		textField_95 = new JTextField();
		textField_95.setForeground(Color.LIGHT_GRAY);
		textField_95.addMouseListener(this);
		textField_95.setText("5");
		textField_95.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_95.setColumns(10);
		textField_95.setBounds(401, 46, 20, 20);
		add(textField_95);
		
		textField_96 = new JTextField();
		textField_96.setForeground(Color.LIGHT_GRAY);
		textField_96.addMouseListener(this);
		textField_96.setText("6");
		textField_96.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_96.setColumns(10);
		textField_96.setBounds(414, 46, 20, 20);
		add(textField_96);
		
		textField_77 = new JTextField();
		textField_77.setForeground(Color.LIGHT_GRAY);
		textField_77.addMouseListener(this);
		textField_77.setText("7");
		textField_77.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_77.setColumns(10);
		textField_77.setBounds(304, 61, 20, 20);
		add(textField_77);
		
		textField_78 = new JTextField();
		textField_78.setForeground(Color.LIGHT_GRAY);
		textField_78.addMouseListener(this);
		textField_78.setText("8");
		textField_78.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_78.setColumns(10);
		textField_78.setBounds(317, 61, 20, 20);
		add(textField_78);
		
		textField_79 = new JTextField();
		textField_79.setForeground(Color.LIGHT_GRAY);
		textField_79.addMouseListener(this);
		textField_79.setText("9");
		textField_79.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_79.setColumns(10);
		textField_79.setBounds(330, 61, 20, 20);
		add(textField_79);
		
		textField_87 = new JTextField();
		textField_87.setForeground(Color.LIGHT_GRAY);
		textField_87.addMouseListener(this);
		textField_87.setText("7");
		textField_87.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_87.setColumns(10);
		textField_87.setBounds(346, 61, 20, 20);
		add(textField_87);
		
		textField_88 = new JTextField();
		textField_88.setForeground(Color.LIGHT_GRAY);
		textField_88.addMouseListener(this);
		textField_88.setText("8");
		textField_88.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_88.setColumns(10);
		textField_88.setBounds(359, 61, 20, 20);
		add(textField_88);
		
		textField_89 = new JTextField();
		textField_89.setForeground(Color.LIGHT_GRAY);
		textField_89.addMouseListener(this);
		textField_89.setText("9");
		textField_89.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_89.setColumns(10);
		textField_89.setBounds(372, 61, 20, 20);
		add(textField_89);
		
		textField_97 = new JTextField();
		textField_97.setForeground(Color.LIGHT_GRAY);
		textField_97.addMouseListener(this);
		textField_97.setText("7");
		textField_97.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_97.setColumns(10);
		textField_97.setBounds(388, 61, 20, 20);
		add(textField_97);
		
		textField_99 = new JTextField();
		textField_99.setForeground(Color.LIGHT_GRAY);
		textField_99.addMouseListener(this);
		textField_99.setText("9");
		textField_99.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_99.setColumns(10);
		textField_99.setBounds(414, 61, 20, 20);
		add(textField_99);
		
		textField_98 = new JTextField();
		textField_98.setForeground(Color.LIGHT_GRAY);
		textField_98.addMouseListener(this);
		textField_98.setText("8");
		textField_98.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_98.setColumns(10);
		textField_98.setBounds(401, 61, 20, 20);
		add(textField_98);
		
		textField_161 = new JTextField();
		textField_161.setForeground(Color.LIGHT_GRAY);
		textField_161.addMouseListener(this);
		textField_161.setText("1");
		textField_161.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_161.setColumns(10);
		textField_161.setBounds(304, 79, 20, 20);
		add(textField_161);
		
		textField_162 = new JTextField();
		textField_162.setForeground(Color.LIGHT_GRAY);
		textField_162.addMouseListener(this);
		textField_162.setText("2");
		textField_162.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_162.setColumns(10);
		textField_162.setBounds(317, 79, 20, 20);
		add(textField_162);
		
		textField_163 = new JTextField();
		textField_163.setForeground(Color.LIGHT_GRAY);
		textField_163.addMouseListener(this);
		textField_163.setText("3");
		textField_163.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_163.setColumns(10);
		textField_163.setBounds(330, 79, 20, 20);
		add(textField_163);
		
		textField_171 = new JTextField();
		textField_171.setForeground(Color.LIGHT_GRAY);
		textField_171.addMouseListener(this);
		textField_171.setText("1");
		textField_171.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_171.setColumns(10);
		textField_171.setBounds(346, 79, 20, 20);
		add(textField_171);
		
		textField_172 = new JTextField();
		textField_172.setForeground(Color.LIGHT_GRAY);
		textField_172.addMouseListener(this);
		textField_172.setText("2");
		textField_172.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_172.setColumns(10);
		textField_172.setBounds(359, 79, 20, 20);
		add(textField_172);
		
		textField_173 = new JTextField();
		textField_173.setForeground(Color.LIGHT_GRAY);
		textField_173.addMouseListener(this);
		textField_173.setText("3");
		textField_173.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_173.setColumns(10);
		textField_173.setBounds(372, 79, 20, 20);
		add(textField_173);
		
		textField_181 = new JTextField();
		textField_181.setForeground(Color.LIGHT_GRAY);
		textField_181.addMouseListener(this);
		textField_181.setText("1");
		textField_181.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_181.setColumns(10);
		textField_181.setBounds(388, 79, 20, 20);
		add(textField_181);
		
		textField_182 = new JTextField();
		textField_182.setForeground(Color.LIGHT_GRAY);
		textField_182.addMouseListener(this);
		textField_182.setText("2");
		textField_182.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_182.setColumns(10);
		textField_182.setBounds(401, 79, 20, 20);
		add(textField_182);
		
		textField_183 = new JTextField();
		textField_183.setForeground(Color.LIGHT_GRAY);
		textField_183.addMouseListener(this);
		textField_183.setText("3");
		textField_183.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_183.setColumns(10);
		textField_183.setBounds(414, 79, 20, 20);
		add(textField_183);
		
		textField_164 = new JTextField();
		textField_164.setForeground(Color.LIGHT_GRAY);
		textField_164.addMouseListener(this);
		textField_164.setText("4");
		textField_164.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_164.setColumns(10);
		textField_164.setBounds(304, 94, 20, 20);
		add(textField_164);
		
		textField_165 = new JTextField();
		textField_165.setForeground(Color.LIGHT_GRAY);
		textField_165.addMouseListener(this);
		textField_165.setText("5");
		textField_165.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_165.setColumns(10);
		textField_165.setBounds(317, 94, 20, 20);
		add(textField_165);
		
		textField_166 = new JTextField();
		textField_166.setForeground(Color.LIGHT_GRAY);
		textField_166.addMouseListener(this);
		textField_166.setText("6");
		textField_166.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_166.setColumns(10);
		textField_166.setBounds(330, 94, 20, 20);
		add(textField_166);
		
		textField_174 = new JTextField();
		textField_174.setForeground(Color.LIGHT_GRAY);
		textField_174.addMouseListener(this);
		textField_174.setText("4");
		textField_174.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_174.setColumns(10);
		textField_174.setBounds(346, 94, 20, 20);
		add(textField_174);
		
		textField_175 = new JTextField();
		textField_175.setForeground(Color.LIGHT_GRAY);
		textField_175.addMouseListener(this);
		textField_175.setText("5");
		textField_175.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_175.setColumns(10);
		textField_175.setBounds(359, 94, 20, 20);
		add(textField_175);
		
		textField_176 = new JTextField();
		textField_176.setForeground(Color.LIGHT_GRAY);
		textField_176.addMouseListener(this);
		textField_176.setText("6");
		textField_176.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_176.setColumns(10);
		textField_176.setBounds(372, 94, 20, 20);
		add(textField_176);
		
		textField_184 = new JTextField();
		textField_184.setForeground(Color.LIGHT_GRAY);
		textField_184.addMouseListener(this);
		textField_184.setText("4");
		textField_184.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_184.setColumns(10);
		textField_184.setBounds(388, 94, 20, 20);
		add(textField_184);
		
		textField_185 = new JTextField();
		textField_185.setForeground(Color.LIGHT_GRAY);
		textField_185.addMouseListener(this);
		textField_185.setText("5");
		textField_185.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_185.setColumns(10);
		textField_185.setBounds(401, 94, 20, 20);
		add(textField_185);
		
		textField_186 = new JTextField();
		textField_186.setForeground(Color.LIGHT_GRAY);
		textField_186.addMouseListener(this);
		textField_186.setText("6");
		textField_186.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_186.setColumns(10);
		textField_186.setBounds(414, 94, 20, 20);
		add(textField_186);
		
		textField_167 = new JTextField();
		textField_167.setForeground(Color.LIGHT_GRAY);
		textField_167.addMouseListener(this);
		textField_167.setText("7");
		textField_167.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_167.setColumns(10);
		textField_167.setBounds(304, 109, 20, 20);
		add(textField_167);
		
		textField_168 = new JTextField();
		textField_168.setForeground(Color.LIGHT_GRAY);
		textField_168.addMouseListener(this);
		textField_168.setText("8");
		textField_168.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_168.setColumns(10);
		textField_168.setBounds(317, 109, 20, 20);
		add(textField_168);
		
		textField_169 = new JTextField();
		textField_169.setForeground(Color.LIGHT_GRAY);
		textField_169.addMouseListener(this);
		textField_169.setText("9");
		textField_169.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_169.setColumns(10);
		textField_169.setBounds(330, 109, 20, 20);
		add(textField_169);
		
		textField_177 = new JTextField();
		textField_177.setForeground(Color.LIGHT_GRAY);
		textField_177.addMouseListener(this);
		textField_177.setText("7");
		textField_177.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_177.setColumns(10);
		textField_177.setBounds(346, 109, 20, 20);
		add(textField_177);
		
		textField_178 = new JTextField();
		textField_178.setForeground(Color.LIGHT_GRAY);
		textField_178.addMouseListener(this);
		textField_178.setText("8");
		textField_178.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_178.setColumns(10);
		textField_178.setBounds(359, 109, 20, 20);
		add(textField_178);
		
		textField_179 = new JTextField();
		textField_179.setForeground(Color.LIGHT_GRAY);
		textField_179.addMouseListener(this);
		textField_179.setText("9");
		textField_179.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_179.setColumns(10);
		textField_179.setBounds(372, 109, 20, 20);
		add(textField_179);
		
		textField_187 = new JTextField();
		textField_187.setForeground(Color.LIGHT_GRAY);
		textField_187.addMouseListener(this);
		textField_187.setText("7");
		textField_187.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_187.setColumns(10);
		textField_187.setBounds(388, 109, 20, 20);
		add(textField_187);
		
		textField_188 = new JTextField();
		textField_188.setForeground(Color.LIGHT_GRAY);
		textField_188.addMouseListener(this);
		textField_188.setText("8");
		textField_188.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_188.setColumns(10);
		textField_188.setBounds(401, 109, 20, 20);
		add(textField_188);
		
		textField_189 = new JTextField();
		textField_189.setForeground(Color.LIGHT_GRAY);
		textField_189.addMouseListener(this);
		textField_189.setText("9");
		textField_189.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_189.setColumns(10);
		textField_189.setBounds(414, 109, 20, 20);
		add(textField_189);
		
		textField_251 = new JTextField();
		textField_251.setForeground(Color.LIGHT_GRAY);
		textField_251.addMouseListener(this);
		textField_251.setText("1");
		textField_251.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_251.setColumns(10);
		textField_251.setBounds(304, 127, 20, 20);
		add(textField_251);
		
		textField_252 = new JTextField();
		textField_252.setForeground(Color.LIGHT_GRAY);
		textField_252.addMouseListener(this);
		textField_252.setText("2");
		textField_252.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_252.setColumns(10);
		textField_252.setBounds(317, 127, 20, 20);
		add(textField_252);
		
		textField_253 = new JTextField();
		textField_253.setForeground(Color.LIGHT_GRAY);
		textField_253.addMouseListener(this);
		textField_253.setText("3");
		textField_253.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_253.setColumns(10);
		textField_253.setBounds(330, 127, 20, 20);
		add(textField_253);
		
		textField_261 = new JTextField();
		textField_261.setForeground(Color.LIGHT_GRAY);
		textField_261.addMouseListener(this);
		textField_261.setText("1");
		textField_261.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_261.setColumns(10);
		textField_261.setBounds(346, 127, 20, 20);
		add(textField_261);
		
		textField_262 = new JTextField();
		textField_262.setForeground(Color.LIGHT_GRAY);
		textField_262.addMouseListener(this);
		textField_262.setText("2");
		textField_262.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_262.setColumns(10);
		textField_262.setBounds(359, 127, 20, 20);
		add(textField_262);
		
		textField_263 = new JTextField();
		textField_263.setForeground(Color.LIGHT_GRAY);
		textField_263.addMouseListener(this);
		textField_263.setText("3");
		textField_263.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_263.setColumns(10);
		textField_263.setBounds(372, 127, 20, 20);
		add(textField_263);
		
		textField_271 = new JTextField();
		textField_271.setForeground(Color.LIGHT_GRAY);
		textField_271.addMouseListener(this);
		textField_271.setText("1");
		textField_271.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_271.setColumns(10);
		textField_271.setBounds(388, 127, 20, 20);
		add(textField_271);
		
		textField_272 = new JTextField();
		textField_272.setForeground(Color.LIGHT_GRAY);
		textField_272.addMouseListener(this);
		textField_272.setText("2");
		textField_272.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_272.setColumns(10);
		textField_272.setBounds(401, 127, 20, 20);
		add(textField_272);
		
		textField_273 = new JTextField();
		textField_273.setForeground(Color.LIGHT_GRAY);
		textField_273.addMouseListener(this);
		textField_273.setText("3");
		textField_273.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_273.setColumns(10);
		textField_273.setBounds(414, 127, 20, 20);
		add(textField_273);
		
		textField_254 = new JTextField();
		textField_254.setForeground(Color.LIGHT_GRAY);
		textField_254.addMouseListener(this);
		textField_254.setText("4");
		textField_254.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_254.setColumns(10);
		textField_254.setBounds(304, 142, 20, 20);
		add(textField_254);
		
		textField_255 = new JTextField();
		textField_255.setForeground(Color.LIGHT_GRAY);
		textField_255.addMouseListener(this);
		textField_255.setText("5");
		textField_255.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_255.setColumns(10);
		textField_255.setBounds(317, 142, 20, 20);
		add(textField_255);
		
		textField_256 = new JTextField();
		textField_256.setForeground(Color.LIGHT_GRAY);
		textField_256.addMouseListener(this);
		textField_256.setText("6");
		textField_256.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_256.setColumns(10);
		textField_256.setBounds(330, 142, 20, 20);
		add(textField_256);
		
		textField_264 = new JTextField();
		textField_264.setForeground(Color.LIGHT_GRAY);
		textField_264.addMouseListener(this);
		textField_264.setText("4");
		textField_264.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_264.setColumns(10);
		textField_264.setBounds(346, 142, 20, 20);
		add(textField_264);
		
		textField_265 = new JTextField();
		textField_265.setForeground(Color.LIGHT_GRAY);
		textField_265.addMouseListener(this);
		textField_265.setText("5");
		textField_265.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_265.setColumns(10);
		textField_265.setBounds(359, 142, 20, 20);
		add(textField_265);
		
		textField_266 = new JTextField();
		textField_266.setForeground(Color.LIGHT_GRAY);
		textField_266.addMouseListener(this);
		textField_266.setText("6");
		textField_266.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_266.setColumns(10);
		textField_266.setBounds(372, 142, 20, 20);
		add(textField_266);
		
		textField_274 = new JTextField();
		textField_274.setForeground(Color.LIGHT_GRAY);
		textField_274.addMouseListener(this);
		textField_274.setText("4");
		textField_274.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_274.setColumns(10);
		textField_274.setBounds(388, 142, 20, 20);
		add(textField_274);
		
		textField_275 = new JTextField();
		textField_275.setForeground(Color.LIGHT_GRAY);
		textField_275.addMouseListener(this);
		textField_275.setText("5");
		textField_275.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_275.setColumns(10);
		textField_275.setBounds(401, 142, 20, 20);
		add(textField_275);
		
		textField_276 = new JTextField();
		textField_276.setForeground(Color.LIGHT_GRAY);
		textField_276.addMouseListener(this);
		textField_276.setText("6");
		textField_276.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_276.setColumns(10);
		textField_276.setBounds(414, 142, 20, 20);
		add(textField_276);
		
		textField_257 = new JTextField();
		textField_257.setForeground(Color.LIGHT_GRAY);
		textField_257.addMouseListener(this);
		textField_257.setText("7");
		textField_257.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_257.setColumns(10);
		textField_257.setBounds(304, 157, 20, 20);
		add(textField_257);
		
		textField_258 = new JTextField();
		textField_258.setForeground(Color.LIGHT_GRAY);
		textField_258.addMouseListener(this);
		textField_258.setText("8");
		textField_258.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_258.setColumns(10);
		textField_258.setBounds(317, 157, 20, 20);
		add(textField_258);
		
		textField_259 = new JTextField();
		textField_259.setForeground(Color.LIGHT_GRAY);
		textField_259.addMouseListener(this);
		textField_259.setText("9");
		textField_259.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_259.setColumns(10);
		textField_259.setBounds(330, 157, 20, 20);
		add(textField_259);
		
		textField_267 = new JTextField();
		textField_267.setForeground(Color.LIGHT_GRAY);
		textField_267.addMouseListener(this);
		textField_267.setText("7");
		textField_267.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_267.setColumns(10);
		textField_267.setBounds(346, 157, 20, 20);
		add(textField_267);
		
		textField_268 = new JTextField();
		textField_268.setForeground(Color.LIGHT_GRAY);
		textField_268.addMouseListener(this);
		textField_268.setText("8");
		textField_268.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_268.setColumns(10);
		textField_268.setBounds(359, 157, 20, 20);
		add(textField_268);
		
		textField_269 = new JTextField();
		textField_269.setForeground(Color.LIGHT_GRAY);
		textField_269.addMouseListener(this);
		textField_269.setText("9");
		textField_269.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_269.setColumns(10);
		textField_269.setBounds(372, 157, 20, 20);
		add(textField_269);
		
		textField_277 = new JTextField();
		textField_277.setForeground(Color.LIGHT_GRAY);
		textField_277.addMouseListener(this);
		textField_277.setText("7");
		textField_277.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_277.setColumns(10);
		textField_277.setBounds(388, 157, 20, 20);
		add(textField_277);
		
		textField_278 = new JTextField();
		textField_278.setForeground(Color.LIGHT_GRAY);
		textField_278.addMouseListener(this);
		textField_278.setText("8");
		textField_278.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_278.setColumns(10);
		textField_278.setBounds(401, 157, 20, 20);
		add(textField_278);
		
		textField_279 = new JTextField();
		textField_279.setForeground(Color.LIGHT_GRAY);
		textField_279.addMouseListener(this);
		textField_279.setText("9");
		textField_279.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_279.setColumns(10);
		textField_279.setBounds(414, 157, 20, 20);
		add(textField_279);
		
		textField_281 = new JTextField();
		textField_281.setForeground(Color.LIGHT_GRAY);
		textField_281.addMouseListener(this);
		textField_281.setText("1");
		textField_281.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_281.setColumns(10);
		textField_281.setBounds(46, 179, 20, 20);
		add(textField_281);
		
		textField_282 = new JTextField();
		textField_282.setForeground(Color.LIGHT_GRAY);
		textField_282.addMouseListener(this);
		textField_282.setText("2");
		textField_282.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_282.setColumns(10);
		textField_282.setBounds(59, 179, 20, 20);
		add(textField_282);
		
		textField_283 = new JTextField();
		textField_283.setForeground(Color.LIGHT_GRAY);
		textField_283.addMouseListener(this);
		textField_283.setText("3");
		textField_283.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_283.setColumns(10);
		textField_283.setBounds(72, 179, 20, 20);
		add(textField_283);
		
		textField_291 = new JTextField();
		textField_291.setForeground(Color.LIGHT_GRAY);
		textField_291.addMouseListener(this);
		textField_291.setText("1");
		textField_291.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_291.setColumns(10);
		textField_291.setBounds(88, 179, 20, 20);
		add(textField_291);
		
		textField_292 = new JTextField();
		textField_292.setForeground(Color.LIGHT_GRAY);
		textField_292.addMouseListener(this);
		textField_292.setText("2");
		textField_292.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_292.setColumns(10);
		textField_292.setBounds(101, 179, 20, 20);
		add(textField_292);
		
		textField_293 = new JTextField();
		textField_293.setForeground(Color.LIGHT_GRAY);
		textField_293.addMouseListener(this);
		textField_293.setText("3");
		textField_293.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_293.setColumns(10);
		textField_293.setBounds(114, 179, 20, 20);
		add(textField_293);
		
		textField_301 = new JTextField();
		textField_301.setForeground(Color.LIGHT_GRAY);
		textField_301.addMouseListener(this);
		textField_301.setText("1");
		textField_301.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_301.setColumns(10);
		textField_301.setBounds(130, 179, 20, 20);
		add(textField_301);
		
		textField_302 = new JTextField();
		textField_302.setForeground(Color.LIGHT_GRAY);
		textField_302.addMouseListener(this);
		textField_302.setText("2");
		textField_302.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_302.setColumns(10);
		textField_302.setBounds(143, 179, 20, 20);
		add(textField_302);
		
		textField_303 = new JTextField();
		textField_303.setForeground(Color.LIGHT_GRAY);
		textField_303.addMouseListener(this);
		textField_303.setText("3");
		textField_303.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_303.setColumns(10);
		textField_303.setBounds(156, 179, 20, 20);
		add(textField_303);
		
		textField_284 = new JTextField();
		textField_284.setForeground(Color.LIGHT_GRAY);
		textField_284.addMouseListener(this);
		textField_284.setText("4");
		textField_284.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_284.setColumns(10);
		textField_284.setBounds(46, 194, 20, 20);
		add(textField_284);
		
		textField_285 = new JTextField();
		textField_285.setForeground(Color.LIGHT_GRAY);
		textField_285.addMouseListener(this);
		textField_285.setText("5");
		textField_285.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_285.setColumns(10);
		textField_285.setBounds(59, 194, 20, 20);
		add(textField_285);
		
		textField_286 = new JTextField();
		textField_286.setForeground(Color.LIGHT_GRAY);
		textField_286.addMouseListener(this);
		textField_286.setText("6");
		textField_286.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_286.setColumns(10);
		textField_286.setBounds(72, 194, 20, 20);
		add(textField_286);
		
		textField_294 = new JTextField();
		textField_294.setForeground(Color.LIGHT_GRAY);
		textField_294.addMouseListener(this);
		textField_294.setText("4");
		textField_294.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_294.setColumns(10);
		textField_294.setBounds(88, 194, 20, 20);
		add(textField_294);
		
		textField_295 = new JTextField();
		textField_295.setForeground(Color.LIGHT_GRAY);
		textField_295.addMouseListener(this);
		textField_295.setText("5");
		textField_295.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_295.setColumns(10);
		textField_295.setBounds(101, 194, 20, 20);
		add(textField_295);
		
		textField_296 = new JTextField();
		textField_296.setForeground(Color.LIGHT_GRAY);
		textField_296.addMouseListener(this);
		textField_296.setText("6");
		textField_296.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_296.setColumns(10);
		textField_296.setBounds(114, 194, 20, 20);
		add(textField_296);
		
		textField_304 = new JTextField();
		textField_304.setForeground(Color.LIGHT_GRAY);
		textField_304.addMouseListener(this);
		textField_304.setText("4");
		textField_304.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_304.setColumns(10);
		textField_304.setBounds(130, 194, 20, 20);
		add(textField_304);
		
		textField_305 = new JTextField();
		textField_305.setForeground(Color.LIGHT_GRAY);
		textField_305.addMouseListener(this);
		textField_305.setText("5");
		textField_305.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_305.setColumns(10);
		textField_305.setBounds(143, 194, 20, 20);
		add(textField_305);
		
		textField_306 = new JTextField();
		textField_306.setForeground(Color.LIGHT_GRAY);
		textField_306.addMouseListener(this);
		textField_306.setText("6");
		textField_306.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_306.setColumns(10);
		textField_306.setBounds(156, 194, 20, 20);
		add(textField_306);
		
		textField_287 = new JTextField();
		textField_287.setForeground(Color.LIGHT_GRAY);
		textField_287.addMouseListener(this);
		textField_287.setText("7");
		textField_287.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_287.setColumns(10);
		textField_287.setBounds(46, 209, 20, 20);
		add(textField_287);
		
		textField_288 = new JTextField();
		textField_288.setForeground(Color.LIGHT_GRAY);
		textField_288.addMouseListener(this);
		textField_288.setText("8");
		textField_288.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_288.setColumns(10);
		textField_288.setBounds(59, 209, 20, 20);
		add(textField_288);
		
		textField_289 = new JTextField();
		textField_289.setForeground(Color.LIGHT_GRAY);
		textField_289.addMouseListener(this);
		textField_289.setText("9");
		textField_289.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_289.setColumns(10);
		textField_289.setBounds(72, 209, 20, 20);
		add(textField_289);
		
		textField_297 = new JTextField();
		textField_297.setForeground(Color.LIGHT_GRAY);
		textField_297.addMouseListener(this);
		textField_297.setText("7");
		textField_297.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_297.setColumns(10);
		textField_297.setBounds(88, 209, 20, 20);
		add(textField_297);
		
		textField_298 = new JTextField();
		textField_298.setForeground(Color.LIGHT_GRAY);
		textField_298.addMouseListener(this);
		textField_298.setText("8");
		textField_298.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_298.setColumns(10);
		textField_298.setBounds(101, 209, 20, 20);
		add(textField_298);
		
		textField_299 = new JTextField();
		textField_299.setForeground(Color.LIGHT_GRAY);
		textField_299.addMouseListener(this);
		textField_299.setText("9");
		textField_299.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_299.setColumns(10);
		textField_299.setBounds(114, 209, 20, 20);
		add(textField_299);
		
		textField_307 = new JTextField();
		textField_307.setForeground(Color.LIGHT_GRAY);
		textField_307.addMouseListener(this);
		textField_307.setText("7");
		textField_307.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_307.setColumns(10);
		textField_307.setBounds(130, 209, 20, 20);
		add(textField_307);
		
		textField_309 = new JTextField();
		textField_309.setForeground(Color.LIGHT_GRAY);
		textField_309.addMouseListener(this);
		textField_309.setText("9");
		textField_309.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_309.setColumns(10);
		textField_309.setBounds(156, 209, 20, 20);
		add(textField_309);
		
		textField_308 = new JTextField();
		textField_308.setForeground(Color.LIGHT_GRAY);
		textField_308.addMouseListener(this);
		textField_308.setText("8");
		textField_308.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_308.setColumns(10);
		textField_308.setBounds(143, 209, 20, 20);
		add(textField_308);
		
		textField_371 = new JTextField();
		textField_371.setForeground(Color.LIGHT_GRAY);
		textField_371.addMouseListener(this);
		textField_371.setText("1");
		textField_371.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_371.setColumns(10);
		textField_371.setBounds(46, 227, 20, 20);
		add(textField_371);
		
		textField_372 = new JTextField();
		textField_372.setForeground(Color.LIGHT_GRAY);
		textField_372.addMouseListener(this);
		textField_372.setText("2");
		textField_372.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_372.setColumns(10);
		textField_372.setBounds(59, 227, 20, 20);
		add(textField_372);
		
		textField_373 = new JTextField();
		textField_373.setForeground(Color.LIGHT_GRAY);
		textField_373.addMouseListener(this);
		textField_373.setText("3");
		textField_373.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_373.setColumns(10);
		textField_373.setBounds(72, 227, 20, 20);
		add(textField_373);
		
		textField_381 = new JTextField();
		textField_381.setForeground(Color.LIGHT_GRAY);
		textField_381.addMouseListener(this);
		textField_381.setText("1");
		textField_381.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_381.setColumns(10);
		textField_381.setBounds(88, 227, 20, 20);
		add(textField_381);
		
		textField_382 = new JTextField();
		textField_382.setForeground(Color.LIGHT_GRAY);
		textField_382.addMouseListener(this);
		textField_382.setText("2");
		textField_382.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_382.setColumns(10);
		textField_382.setBounds(101, 227, 20, 20);
		add(textField_382);
		
		textField_383 = new JTextField();
		textField_383.setForeground(Color.LIGHT_GRAY);
		textField_383.addMouseListener(this);
		textField_383.setText("3");
		textField_383.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_383.setColumns(10);
		textField_383.setBounds(114, 227, 20, 20);
		add(textField_383);
		
		textField_391 = new JTextField();
		textField_391.setForeground(Color.LIGHT_GRAY);
		textField_391.addMouseListener(this);
		textField_391.setText("1");
		textField_391.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_391.setColumns(10);
		textField_391.setBounds(130, 227, 20, 20);
		add(textField_391);
		
		textField_392 = new JTextField();
		textField_392.setForeground(Color.LIGHT_GRAY);
		textField_392.addMouseListener(this);
		textField_392.setText("2");
		textField_392.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_392.setColumns(10);
		textField_392.setBounds(143, 227, 20, 20);
		add(textField_392);
		
		textField_393 = new JTextField();
		textField_393.setForeground(Color.LIGHT_GRAY);
		textField_393.addMouseListener(this);
		textField_393.setText("3");
		textField_393.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_393.setColumns(10);
		textField_393.setBounds(156, 227, 20, 20);
		add(textField_393);
		
		textField_374 = new JTextField();
		textField_374.setForeground(Color.LIGHT_GRAY);
		textField_374.addMouseListener(this);
		textField_374.setText("4");
		textField_374.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_374.setColumns(10);
		textField_374.setBounds(46, 242, 20, 20);
		add(textField_374);
		
		textField_375 = new JTextField();
		textField_375.setForeground(Color.LIGHT_GRAY);
		textField_375.addMouseListener(this);
		textField_375.setText("5");
		textField_375.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_375.setColumns(10);
		textField_375.setBounds(59, 242, 20, 20);
		add(textField_375);
		
		textField_376 = new JTextField();
		textField_376.setForeground(Color.LIGHT_GRAY);
		textField_376.addMouseListener(this);
		textField_376.setText("6");
		textField_376.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_376.setColumns(10);
		textField_376.setBounds(72, 242, 20, 20);
		add(textField_376);
		
		textField_384 = new JTextField();
		textField_384.setForeground(Color.LIGHT_GRAY);
		textField_384.addMouseListener(this);
		textField_384.setText("4");
		textField_384.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_384.setColumns(10);
		textField_384.setBounds(88, 242, 20, 20);
		add(textField_384);
		
		textField_385 = new JTextField();
		textField_385.setForeground(Color.LIGHT_GRAY);
		textField_385.addMouseListener(this);
		textField_385.setText("5");
		textField_385.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_385.setColumns(10);
		textField_385.setBounds(101, 242, 20, 20);
		add(textField_385);
		
		textField_386 = new JTextField();
		textField_386.setForeground(Color.LIGHT_GRAY);
		textField_386.addMouseListener(this);
		textField_386.setText("6");
		textField_386.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_386.setColumns(10);
		textField_386.setBounds(114, 242, 20, 20);
		add(textField_386);
		
		textField_394 = new JTextField();
		textField_394.setForeground(Color.LIGHT_GRAY);
		textField_394.addMouseListener(this);
		textField_394.setText("4");
		textField_394.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_394.setColumns(10);
		textField_394.setBounds(130, 242, 20, 20);
		add(textField_394);
		
		textField_395 = new JTextField();
		textField_395.setForeground(Color.LIGHT_GRAY);
		textField_395.addMouseListener(this);
		textField_395.setText("5");
		textField_395.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_395.setColumns(10);
		textField_395.setBounds(143, 242, 20, 20);
		add(textField_395);
		
		textField_396 = new JTextField();
		textField_396.setForeground(Color.LIGHT_GRAY);
		textField_396.addMouseListener(this);
		textField_396.setText("6");
		textField_396.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_396.setColumns(10);
		textField_396.setBounds(156, 242, 20, 20);
		add(textField_396);
		
		textField_377 = new JTextField();
		textField_377.setForeground(Color.LIGHT_GRAY);
		textField_377.addMouseListener(this);
		textField_377.setText("7");
		textField_377.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_377.setColumns(10);
		textField_377.setBounds(46, 257, 20, 20);
		add(textField_377);
		
		textField_378 = new JTextField();
		textField_378.setForeground(Color.LIGHT_GRAY);
		textField_378.addMouseListener(this);
		textField_378.setText("8");
		textField_378.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_378.setColumns(10);
		textField_378.setBounds(59, 257, 20, 20);
		add(textField_378);
		
		textField_379 = new JTextField();
		textField_379.setForeground(Color.LIGHT_GRAY);
		textField_379.addMouseListener(this);
		textField_379.setText("9");
		textField_379.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_379.setColumns(10);
		textField_379.setBounds(72, 257, 20, 20);
		add(textField_379);
		
		textField_387 = new JTextField();
		textField_387.setForeground(Color.LIGHT_GRAY);
		textField_387.addMouseListener(this);
		textField_387.setText("7");
		textField_387.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_387.setColumns(10);
		textField_387.setBounds(88, 257, 20, 20);
		add(textField_387);
		
		textField_388 = new JTextField();
		textField_388.setForeground(Color.LIGHT_GRAY);
		textField_388.addMouseListener(this);
		textField_388.setText("8");
		textField_388.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_388.setColumns(10);
		textField_388.setBounds(101, 257, 20, 20);
		add(textField_388);
	}
	private void initComponent2(){
		textField_389 = new JTextField();
		textField_389.setForeground(Color.LIGHT_GRAY);
		textField_389.addMouseListener(this);
		textField_389.setText("9");
		textField_389.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_389.setColumns(10);
		textField_389.setBounds(114, 257, 20, 20);
		add(textField_389);
		
		textField_397 = new JTextField();
		textField_397.setForeground(Color.LIGHT_GRAY);
		textField_397.addMouseListener(this);
		textField_397.setText("7");
		textField_397.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_397.setColumns(10);
		textField_397.setBounds(130, 257, 20, 20);
		add(textField_397);
		
		textField_398 = new JTextField();
		textField_398.setForeground(Color.LIGHT_GRAY);
		textField_398.addMouseListener(this);
		textField_398.setText("8");
		textField_398.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_398.setColumns(10);
		textField_398.setBounds(143, 257, 20, 20);
		add(textField_398);
		
		textField_399 = new JTextField();
		textField_399.setForeground(Color.LIGHT_GRAY);
		textField_399.addMouseListener(this);
		textField_399.setText("9");
		textField_399.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_399.setColumns(10);
		textField_399.setBounds(156, 257, 20, 20);
		add(textField_399);
		
		textField_461 = new JTextField();
		textField_461.setForeground(Color.LIGHT_GRAY);
		textField_461.addMouseListener(this);
		textField_461.setText("1");
		textField_461.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_461.setColumns(10);
		textField_461.setBounds(46, 275, 20, 20);
		add(textField_461);
		
		textField_462 = new JTextField();
		textField_462.setForeground(Color.LIGHT_GRAY);
		textField_462.addMouseListener(this);
		textField_462.setText("2");
		textField_462.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_462.setColumns(10);
		textField_462.setBounds(59, 275, 20, 20);
		add(textField_462);
		
		textField_463 = new JTextField();
		textField_463.setForeground(Color.LIGHT_GRAY);
		textField_463.addMouseListener(this);
		textField_463.setText("3");
		textField_463.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_463.setColumns(10);
		textField_463.setBounds(72, 275, 20, 20);
		add(textField_463);
		
		textField_471 = new JTextField();
		textField_471.setForeground(Color.LIGHT_GRAY);
		textField_471.addMouseListener(this);
		textField_471.setText("1");
		textField_471.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_471.setColumns(10);
		textField_471.setBounds(88, 275, 20, 20);
		add(textField_471);
		
		textField_472 = new JTextField();
		textField_472.setForeground(Color.LIGHT_GRAY);
		textField_472.addMouseListener(this);
		textField_472.setText("2");
		textField_472.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_472.setColumns(10);
		textField_472.setBounds(101, 275, 20, 20);
		add(textField_472);
		
		textField_473 = new JTextField();
		textField_473.setForeground(Color.LIGHT_GRAY);
		textField_473.addMouseListener(this);
		textField_473.setText("3");
		textField_473.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_473.setColumns(10);
		textField_473.setBounds(114, 275, 20, 20);
		add(textField_473);
		
		textField_481 = new JTextField();
		textField_481.setForeground(Color.LIGHT_GRAY);
		textField_481.addMouseListener(this);
		textField_481.setText("1");
		textField_481.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_481.setColumns(10);
		textField_481.setBounds(130, 275, 20, 20);
		add(textField_481);
		
		textField_482 = new JTextField();
		textField_482.setForeground(Color.LIGHT_GRAY);
		textField_482.addMouseListener(this);
		textField_482.setText("2");
		textField_482.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_482.setColumns(10);
		textField_482.setBounds(143, 275, 20, 20);
		add(textField_482);
		
		textField_483 = new JTextField();
		textField_483.setForeground(Color.LIGHT_GRAY);
		textField_483.addMouseListener(this);
		textField_483.setText("3");
		textField_483.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_483.setColumns(10);
		textField_483.setBounds(156, 275, 20, 20);
		add(textField_483);
		
		textField_464 = new JTextField();
		textField_464.setForeground(Color.LIGHT_GRAY);
		textField_464.addMouseListener(this);
		textField_464.setText("4");
		textField_464.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_464.setColumns(10);
		textField_464.setBounds(46, 290, 20, 20);
		add(textField_464);
		
		textField_465 = new JTextField();
		textField_465.setForeground(Color.LIGHT_GRAY);
		textField_465.addMouseListener(this);
		textField_465.setText("5");
		textField_465.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_465.setColumns(10);
		textField_465.setBounds(59, 290, 20, 20);
		add(textField_465);
		
		textField_466 = new JTextField();
		textField_466.setForeground(Color.LIGHT_GRAY);
		textField_466.addMouseListener(this);
		textField_466.setText("6");
		textField_466.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_466.setColumns(10);
		textField_466.setBounds(72, 290, 20, 20);
		add(textField_466);
		
		textField_474 = new JTextField();
		textField_474.setForeground(Color.LIGHT_GRAY);
		textField_474.addMouseListener(this);
		textField_474.setText("4");
		textField_474.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_474.setColumns(10);
		textField_474.setBounds(88, 290, 20, 20);
		add(textField_474);
		
		textField_475 = new JTextField();
		textField_475.setForeground(Color.LIGHT_GRAY);
		textField_475.addMouseListener(this);
		textField_475.setText("5");
		textField_475.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_475.setColumns(10);
		textField_475.setBounds(101, 290, 20, 20);
		add(textField_475);
		
		textField_476 = new JTextField();
		textField_476.setForeground(Color.LIGHT_GRAY);
		textField_476.addMouseListener(this);
		textField_476.setText("6");
		textField_476.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_476.setColumns(10);
		textField_476.setBounds(114, 290, 20, 20);
		add(textField_476);
		
		textField_484 = new JTextField();
		textField_484.setForeground(Color.LIGHT_GRAY);
		textField_484.addMouseListener(this);
		textField_484.setText("4");
		textField_484.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_484.setColumns(10);
		textField_484.setBounds(130, 290, 20, 20);
		add(textField_484);
		
		textField_485 = new JTextField();
		textField_485.setForeground(Color.LIGHT_GRAY);
		textField_485.addMouseListener(this);
		textField_485.setText("5");
		textField_485.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_485.setColumns(10);
		textField_485.setBounds(143, 290, 20, 20);
		add(textField_485);
		
		textField_486 = new JTextField();
		textField_486.setForeground(Color.LIGHT_GRAY);
		textField_486.addMouseListener(this);
		textField_486.setText("6");
		textField_486.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_486.setColumns(10);
		textField_486.setBounds(156, 290, 20, 20);
		add(textField_486);
		
		textField_467 = new JTextField();
		textField_467.setForeground(Color.LIGHT_GRAY);
		textField_467.addMouseListener(this);
		textField_467.setText("7");
		textField_467.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_467.setColumns(10);
		textField_467.setBounds(46, 305, 20, 20);
		add(textField_467);
		
		textField_468 = new JTextField();
		textField_468.setForeground(Color.LIGHT_GRAY);
		textField_468.addMouseListener(this);
		textField_468.setText("8");
		textField_468.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_468.setColumns(10);
		textField_468.setBounds(59, 305, 20, 20);
		add(textField_468);
		
		textField_469 = new JTextField();
		textField_469.setForeground(Color.LIGHT_GRAY);
		textField_469.addMouseListener(this);
		textField_469.setText("9");
		textField_469.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_469.setColumns(10);
		textField_469.setBounds(72, 305, 20, 20);
		add(textField_469);
		
		textField_477 = new JTextField();
		textField_477.setForeground(Color.LIGHT_GRAY);
		textField_477.addMouseListener(this);
		textField_477.setText("7");
		textField_477.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_477.setColumns(10);
		textField_477.setBounds(88, 305, 20, 20);
		add(textField_477);
		
		textField_478 = new JTextField();
		textField_478.setForeground(Color.LIGHT_GRAY);
		textField_478.addMouseListener(this);
		textField_478.setText("8");
		textField_478.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_478.setColumns(10);
		textField_478.setBounds(101, 305, 20, 20);
		add(textField_478);
		
		textField_479 = new JTextField();
		textField_479.setForeground(Color.LIGHT_GRAY);
		textField_479.addMouseListener(this);
		textField_479.setText("9");
		textField_479.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_479.setColumns(10);
		textField_479.setBounds(114, 305, 20, 20);
		add(textField_479);
		
		textField_487 = new JTextField();
		textField_487.setForeground(Color.LIGHT_GRAY);
		textField_487.addMouseListener(this);
		textField_487.setText("7");
		textField_487.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_487.setColumns(10);
		textField_487.setBounds(130, 305, 20, 20);
		add(textField_487);
		
		textField_488 = new JTextField();
		textField_488.setForeground(Color.LIGHT_GRAY);
		textField_488.addMouseListener(this);
		textField_488.setText("8");
		textField_488.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_488.setColumns(10);
		textField_488.setBounds(143, 305, 20, 20);
		add(textField_488);
		
		textField_489 = new JTextField();
		textField_489.setForeground(Color.LIGHT_GRAY);
		textField_489.addMouseListener(this);
		textField_489.setText("9");
		textField_489.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_489.setColumns(10);
		textField_489.setBounds(156, 305, 20, 20);
		add(textField_489);
		
		textField_311 = new JTextField();
		textField_311.setForeground(Color.LIGHT_GRAY);
		textField_311.addMouseListener(this);
		textField_311.setText("1");
		textField_311.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_311.setColumns(10);
		textField_311.setBounds(175, 179, 20, 20);
		add(textField_311);
		
		textField_312 = new JTextField();
		textField_312.setForeground(Color.LIGHT_GRAY);
		textField_312.addMouseListener(this);
		textField_312.setText("2");
		textField_312.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_312.setColumns(10);
		textField_312.setBounds(188, 179, 20, 20);
		add(textField_312);
		
		textField_313 = new JTextField();
		textField_313.setForeground(Color.LIGHT_GRAY);
		textField_313.addMouseListener(this);
		textField_313.setText("3");
		textField_313.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_313.setColumns(10);
		textField_313.setBounds(201, 179, 20, 20);
		add(textField_313);
		
		textField_321 = new JTextField();
		textField_321.setForeground(Color.LIGHT_GRAY);
		textField_321.addMouseListener(this);
		textField_321.setText("1");
		textField_321.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_321.setColumns(10);
		textField_321.setBounds(217, 179, 20, 20);
		add(textField_321);
		
		textField_322 = new JTextField();
		textField_322.setForeground(Color.LIGHT_GRAY);
		textField_322.addMouseListener(this);
		textField_322.setText("2");
		textField_322.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_322.setColumns(10);
		textField_322.setBounds(230, 179, 20, 20);
		add(textField_322);
		
		textField_323 = new JTextField();
		textField_323.setForeground(Color.LIGHT_GRAY);
		textField_323.addMouseListener(this);
		textField_323.setText("3");
		textField_323.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_323.setColumns(10);
		textField_323.setBounds(243, 179, 20, 20);
		add(textField_323);
		
		textField_331 = new JTextField();
		textField_331.setForeground(Color.LIGHT_GRAY);
		textField_331.addMouseListener(this);
		textField_331.setText("1");
		textField_331.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_331.setColumns(10);
		textField_331.setBounds(259, 179, 20, 20);
		add(textField_331);
		
		textField_332 = new JTextField();
		textField_332.setForeground(Color.LIGHT_GRAY);
		textField_332.addMouseListener(this);
		textField_332.setText("2");
		textField_332.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_332.setColumns(10);
		textField_332.setBounds(272, 179, 20, 20);
		add(textField_332);
		
		textField_333 = new JTextField();
		textField_333.setForeground(Color.LIGHT_GRAY);
		textField_333.addMouseListener(this);
		textField_333.setText("3");
		textField_333.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_333.setColumns(10);
		textField_333.setBounds(285, 179, 20, 20);
		add(textField_333);
		
		textField_314 = new JTextField();
		textField_314.setForeground(Color.LIGHT_GRAY);
		textField_314.addMouseListener(this);
		textField_314.setText("4");
		textField_314.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_314.setColumns(10);
		textField_314.setBounds(175, 194, 20, 20);
		add(textField_314);
		
		textField_315 = new JTextField();
		textField_315.setForeground(Color.LIGHT_GRAY);
		textField_315.addMouseListener(this);
		textField_315.setText("5");
		textField_315.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_315.setColumns(10);
		textField_315.setBounds(188, 194, 20, 20);
		add(textField_315);
		
		textField_316 = new JTextField();
		textField_316.setForeground(Color.LIGHT_GRAY);
		textField_316.addMouseListener(this);
		textField_316.setText("6");
		textField_316.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_316.setColumns(10);
		textField_316.setBounds(201, 194, 20, 20);
		add(textField_316);
		
		textField_324 = new JTextField();
		textField_324.setForeground(Color.LIGHT_GRAY);
		textField_324.addMouseListener(this);
		textField_324.setText("4");
		textField_324.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_324.setColumns(10);
		textField_324.setBounds(217, 194, 20, 20);
		add(textField_324);
		
		textField_325 = new JTextField();
		textField_325.setForeground(Color.LIGHT_GRAY);
		textField_325.addMouseListener(this);
		textField_325.setText("5");
		textField_325.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_325.setColumns(10);
		textField_325.setBounds(230, 194, 20, 20);
		add(textField_325);
		
		textField_326 = new JTextField();
		textField_326.setForeground(Color.LIGHT_GRAY);
		textField_326.addMouseListener(this);
		textField_326.setText("6");
		textField_326.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_326.setColumns(10);
		textField_326.setBounds(243, 194, 20, 20);
		add(textField_326);
		
		textField_334 = new JTextField();
		textField_334.setForeground(Color.LIGHT_GRAY);
		textField_334.addMouseListener(this);
		textField_334.setText("4");
		textField_334.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_334.setColumns(10);
		textField_334.setBounds(259, 194, 20, 20);
		add(textField_334);
		
		textField_335 = new JTextField();
		textField_335.setForeground(Color.LIGHT_GRAY);
		textField_335.addMouseListener(this);
		textField_335.setText("5");
		textField_335.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_335.setColumns(10);
		textField_335.setBounds(272, 194, 20, 20);
		add(textField_335);
		
		textField_336 = new JTextField();
		textField_336.setForeground(Color.LIGHT_GRAY);
		textField_336.addMouseListener(this);
		textField_336.setText("6");
		textField_336.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_336.setColumns(10);
		textField_336.setBounds(285, 194, 20, 20);
		add(textField_336);
		
		textField_317 = new JTextField();
		textField_317.setForeground(Color.LIGHT_GRAY);
		textField_317.addMouseListener(this);
		textField_317.setText("7");
		textField_317.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_317.setColumns(10);
		textField_317.setBounds(175, 209, 20, 20);
		add(textField_317);
		
		textField_318 = new JTextField();
		textField_318.setForeground(Color.LIGHT_GRAY);
		textField_318.addMouseListener(this);
		textField_318.setText("8");
		textField_318.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_318.setColumns(10);
		textField_318.setBounds(188, 209, 20, 20);
		add(textField_318);
		
		textField_319 = new JTextField();
		textField_319.setForeground(Color.LIGHT_GRAY);
		textField_319.addMouseListener(this);
		textField_319.setText("9");
		textField_319.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_319.setColumns(10);
		textField_319.setBounds(201, 209, 20, 20);
		add(textField_319);
		
		textField_327 = new JTextField();
		textField_327.setForeground(Color.LIGHT_GRAY);
		textField_327.addMouseListener(this);
		textField_327.setText("7");
		textField_327.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_327.setColumns(10);
		textField_327.setBounds(217, 209, 20, 20);
		add(textField_327);
		
		textField_328 = new JTextField();
		textField_328.setForeground(Color.LIGHT_GRAY);
		textField_328.addMouseListener(this);
		textField_328.setText("8");
		textField_328.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_328.setColumns(10);
		textField_328.setBounds(230, 209, 20, 20);
		add(textField_328);
		
		textField_329 = new JTextField();
		textField_329.setForeground(Color.LIGHT_GRAY);
		textField_329.addMouseListener(this);
		textField_329.setText("9");
		textField_329.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_329.setColumns(10);
		textField_329.setBounds(243, 209, 20, 20);
		add(textField_329);
		
		textField_337 = new JTextField();
		textField_337.setForeground(Color.LIGHT_GRAY);
		textField_337.addMouseListener(this);
		textField_337.setText("7");
		textField_337.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_337.setColumns(10);
		textField_337.setBounds(259, 209, 20, 20);
		add(textField_337);
		
		textField_339 = new JTextField();
		textField_339.setForeground(Color.LIGHT_GRAY);
		textField_339.addMouseListener(this);
		textField_339.setText("9");
		textField_339.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_339.setColumns(10);
		textField_339.setBounds(285, 209, 20, 20);
		add(textField_339);
		
		textField_338 = new JTextField();
		textField_338.setForeground(Color.LIGHT_GRAY);
		textField_338.addMouseListener(this);
		textField_338.setText("8");
		textField_338.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_338.setColumns(10);
		textField_338.setBounds(272, 209, 20, 20);
		add(textField_338);
		
		textField_401 = new JTextField();
		textField_401.setForeground(Color.LIGHT_GRAY);
		textField_401.addMouseListener(this);
		textField_401.setText("1");
		textField_401.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_401.setColumns(10);
		textField_401.setBounds(175, 227, 20, 20);
		add(textField_401);
		
		textField_402 = new JTextField();
		textField_402.setForeground(Color.LIGHT_GRAY);
		textField_402.addMouseListener(this);
		textField_402.setText("2");
		textField_402.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_402.setColumns(10);
		textField_402.setBounds(188, 227, 20, 20);
		add(textField_402);
		
		textField_403 = new JTextField();
		textField_403.setForeground(Color.LIGHT_GRAY);
		textField_403.addMouseListener(this);
		textField_403.setText("3");
		textField_403.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_403.setColumns(10);
		textField_403.setBounds(201, 227, 20, 20);
		add(textField_403);
		
		textField_411 = new JTextField();
		textField_411.setForeground(Color.LIGHT_GRAY);
		textField_411.addMouseListener(this);
		textField_411.setText("1");
		textField_411.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_411.setColumns(10);
		textField_411.setBounds(217, 227, 20, 20);
		add(textField_411);
		
		textField_412 = new JTextField();
		textField_412.setForeground(Color.LIGHT_GRAY);
		textField_412.addMouseListener(this);
		textField_412.setText("2");
		textField_412.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_412.setColumns(10);
		textField_412.setBounds(230, 227, 20, 20);
		add(textField_412);
		
		textField_413 = new JTextField();
		textField_413.setForeground(Color.LIGHT_GRAY);
		textField_413.addMouseListener(this);
		textField_413.setText("3");
		textField_413.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_413.setColumns(10);
		textField_413.setBounds(243, 227, 20, 20);
		add(textField_413);
		
		textField_421 = new JTextField();
		textField_421.setForeground(Color.LIGHT_GRAY);
		textField_421.addMouseListener(this);
		textField_421.setText("1");
		textField_421.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_421.setColumns(10);
		textField_421.setBounds(259, 227, 20, 20);
		add(textField_421);
		
		textField_422 = new JTextField();
		textField_422.setForeground(Color.LIGHT_GRAY);
		textField_422.addMouseListener(this);
		textField_422.setText("2");
		textField_422.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_422.setColumns(10);
		textField_422.setBounds(272, 227, 20, 20);
		add(textField_422);
		
		textField_423 = new JTextField();
		textField_423.setForeground(Color.LIGHT_GRAY);
		textField_423.addMouseListener(this);
		textField_423.setText("3");
		textField_423.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_423.setColumns(10);
		textField_423.setBounds(285, 227, 20, 20);
		add(textField_423);
		
		textField_404 = new JTextField();
		textField_404.setForeground(Color.LIGHT_GRAY);
		textField_404.addMouseListener(this);
		textField_404.setText("4");
		textField_404.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_404.setColumns(10);
		textField_404.setBounds(175, 242, 20, 20);
		add(textField_404);
		
		textField_405 = new JTextField();
		textField_405.setForeground(Color.LIGHT_GRAY);
		textField_405.addMouseListener(this);
		textField_405.setText("5");
		textField_405.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_405.setColumns(10);
		textField_405.setBounds(188, 242, 20, 20);
		add(textField_405);
		
		textField_406 = new JTextField();
		textField_406.setForeground(Color.LIGHT_GRAY);
		textField_406.addMouseListener(this);
		textField_406.setText("6");
		textField_406.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_406.setColumns(10);
		textField_406.setBounds(201, 242, 20, 20);
		add(textField_406);
		
		textField_414 = new JTextField();
		textField_414.setForeground(Color.LIGHT_GRAY);
		textField_414.addMouseListener(this);
		textField_414.setText("4");
		textField_414.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_414.setColumns(10);
		textField_414.setBounds(217, 242, 20, 20);
		add(textField_414);
		
		textField_415 = new JTextField();
		textField_415.setForeground(Color.LIGHT_GRAY);
		textField_415.addMouseListener(this);
		textField_415.setText("5");
		textField_415.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_415.setColumns(10);
		textField_415.setBounds(230, 242, 20, 20);
		add(textField_415);
		
		textField_416 = new JTextField();
		textField_416.setForeground(Color.LIGHT_GRAY);
		textField_416.addMouseListener(this);
		textField_416.setText("6");
		textField_416.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_416.setColumns(10);
		textField_416.setBounds(243, 242, 20, 20);
		add(textField_416);
		
		textField_424 = new JTextField();
		textField_424.setForeground(Color.LIGHT_GRAY);
		textField_424.addMouseListener(this);
		textField_424.setText("4");
		textField_424.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_424.setColumns(10);
		textField_424.setBounds(259, 242, 20, 20);
		add(textField_424);
		
		textField_425 = new JTextField();
		textField_425.setForeground(Color.LIGHT_GRAY);
		textField_425.addMouseListener(this);
		textField_425.setText("5");
		textField_425.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_425.setColumns(10);
		textField_425.setBounds(272, 242, 20, 20);
		add(textField_425);
		
		textField_426 = new JTextField();
		textField_426.setForeground(Color.LIGHT_GRAY);
		textField_426.addMouseListener(this);
		textField_426.setText("6");
		textField_426.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_426.setColumns(10);
		textField_426.setBounds(285, 242, 20, 20);
		add(textField_426);
		
		textField_407 = new JTextField();
		textField_407.setForeground(Color.LIGHT_GRAY);
		textField_407.addMouseListener(this);
		textField_407.setText("7");
		textField_407.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_407.setColumns(10);
		textField_407.setBounds(175, 257, 20, 20);
		add(textField_407);
		
		textField_408 = new JTextField();
		textField_408.setForeground(Color.LIGHT_GRAY);
		textField_408.addMouseListener(this);
		textField_408.setText("8");
		textField_408.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_408.setColumns(10);
		textField_408.setBounds(188, 257, 20, 20);
		add(textField_408);
		
		textField_409 = new JTextField();
		textField_409.setForeground(Color.LIGHT_GRAY);
		textField_409.addMouseListener(this);
		textField_409.setText("9");
		textField_409.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_409.setColumns(10);
		textField_409.setBounds(201, 257, 20, 20);
		add(textField_409);
		
		textField_417 = new JTextField();
		textField_417.setForeground(Color.LIGHT_GRAY);
		textField_417.addMouseListener(this);
		textField_417.setText("7");
		textField_417.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_417.setColumns(10);
		textField_417.setBounds(217, 257, 20, 20);
		add(textField_417);
		
		textField_418 = new JTextField();
		textField_418.setForeground(Color.LIGHT_GRAY);
		textField_418.addMouseListener(this);
		textField_418.setText("8");
		textField_418.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_418.setColumns(10);
		textField_418.setBounds(230, 257, 20, 20);
		add(textField_418);
		
		textField_419 = new JTextField();
		textField_419.setForeground(Color.LIGHT_GRAY);
		textField_419.addMouseListener(this);
		textField_419.setText("9");
		textField_419.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_419.setColumns(10);
		textField_419.setBounds(243, 257, 20, 20);
		add(textField_419);
		
		textField_427 = new JTextField();
		textField_427.setForeground(Color.LIGHT_GRAY);
		textField_427.addMouseListener(this);
		textField_427.setText("7");
		textField_427.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_427.setColumns(10);
		textField_427.setBounds(259, 257, 20, 20);
		add(textField_427);
		
		textField_428 = new JTextField();
		textField_428.setForeground(Color.LIGHT_GRAY);
		textField_428.addMouseListener(this);
		textField_428.setText("8");
		textField_428.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_428.setColumns(10);
		textField_428.setBounds(272, 257, 20, 20);
		add(textField_428);
		
		textField_429 = new JTextField();
		textField_429.setForeground(Color.LIGHT_GRAY);
		textField_429.addMouseListener(this);
		textField_429.setText("9");
		textField_429.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_429.setColumns(10);
		textField_429.setBounds(285, 257, 20, 20);
		add(textField_429);
		
		textField_491 = new JTextField();
		textField_491.setForeground(Color.LIGHT_GRAY);
		textField_491.addMouseListener(this);
		textField_491.setText("1");
		textField_491.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_491.setColumns(10);
		textField_491.setBounds(175, 275, 20, 20);
		add(textField_491);
		
		textField_492 = new JTextField();
		textField_492.setForeground(Color.LIGHT_GRAY);
		textField_492.addMouseListener(this);
		textField_492.setText("2");
		textField_492.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_492.setColumns(10);
		textField_492.setBounds(188, 275, 20, 20);
		add(textField_492);
		
		textField_493 = new JTextField();
		textField_493.setForeground(Color.LIGHT_GRAY);
		textField_493.addMouseListener(this);
		textField_493.setText("3");
		textField_493.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_493.setColumns(10);
		textField_493.setBounds(201, 275, 20, 20);
		add(textField_493);
		
		textField_501 = new JTextField();
		textField_501.setForeground(Color.LIGHT_GRAY);
		textField_501.addMouseListener(this);
		textField_501.setText("1");
		textField_501.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_501.setColumns(10);
		textField_501.setBounds(217, 275, 20, 20);
		add(textField_501);
		
		textField_502 = new JTextField();
		textField_502.setForeground(Color.LIGHT_GRAY);
		textField_502.addMouseListener(this);
		textField_502.setText("2");
		textField_502.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_502.setColumns(10);
		textField_502.setBounds(230, 275, 20, 20);
		add(textField_502);
		
		textField_503 = new JTextField();
		textField_503.setForeground(Color.LIGHT_GRAY);
		textField_503.addMouseListener(this);
		textField_503.setText("3");
		textField_503.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_503.setColumns(10);
		textField_503.setBounds(243, 275, 20, 20);
		add(textField_503);
		
		textField_511 = new JTextField();
		textField_511.setForeground(Color.LIGHT_GRAY);
		textField_511.addMouseListener(this);
		textField_511.setText("1");
		textField_511.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_511.setColumns(10);
		textField_511.setBounds(259, 275, 20, 20);
		add(textField_511);
		
		textField_512 = new JTextField();
		textField_512.setForeground(Color.LIGHT_GRAY);
		textField_512.addMouseListener(this);
		textField_512.setText("2");
		textField_512.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_512.setColumns(10);
		textField_512.setBounds(272, 275, 20, 20);
		add(textField_512);
		
		textField_513 = new JTextField();
		textField_513.setForeground(Color.LIGHT_GRAY);
		textField_513.addMouseListener(this);
		textField_513.setText("3");
		textField_513.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_513.setColumns(10);
		textField_513.setBounds(285, 275, 20, 20);
		add(textField_513);
		
		textField_494 = new JTextField();
		textField_494.setForeground(Color.LIGHT_GRAY);
		textField_494.addMouseListener(this);
		textField_494.setText("4");
		textField_494.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_494.setColumns(10);
		textField_494.setBounds(175, 290, 20, 20);
		add(textField_494);
		
		textField_495 = new JTextField();
		textField_495.setForeground(Color.LIGHT_GRAY);
		textField_495.addMouseListener(this);
		textField_495.setText("5");
		textField_495.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_495.setColumns(10);
		textField_495.setBounds(188, 290, 20, 20);
		add(textField_495);
		
		textField_496 = new JTextField();
		textField_496.setForeground(Color.LIGHT_GRAY);
		textField_496.addMouseListener(this);
		textField_496.setText("6");
		textField_496.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_496.setColumns(10);
		textField_496.setBounds(201, 290, 20, 20);
		add(textField_496);
		
		textField_504 = new JTextField();
		textField_504.setForeground(Color.LIGHT_GRAY);
		textField_504.addMouseListener(this);
		textField_504.setText("4");
		textField_504.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_504.setColumns(10);
		textField_504.setBounds(217, 290, 20, 20);
		add(textField_504);
		
		textField_505 = new JTextField();
		textField_505.setForeground(Color.LIGHT_GRAY);
		textField_505.addMouseListener(this);
		textField_505.setText("5");
		textField_505.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_505.setColumns(10);
		textField_505.setBounds(230, 290, 20, 20);
		add(textField_505);
		
		textField_506 = new JTextField();
		textField_506.setForeground(Color.LIGHT_GRAY);
		textField_506.addMouseListener(this);
		textField_506.setText("6");
		textField_506.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_506.setColumns(10);
		textField_506.setBounds(243, 290, 20, 20);
		add(textField_506);
		
		textField_514 = new JTextField();
		textField_514.setForeground(Color.LIGHT_GRAY);
		textField_514.addMouseListener(this);
		textField_514.setText("4");
		textField_514.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_514.setColumns(10);
		textField_514.setBounds(259, 290, 20, 20);
		add(textField_514);
		
		textField_515 = new JTextField();
		textField_515.setForeground(Color.LIGHT_GRAY);
		textField_515.addMouseListener(this);
		textField_515.setText("5");
		textField_515.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_515.setColumns(10);
		textField_515.setBounds(272, 290, 20, 20);
		add(textField_515);
		
		textField_516 = new JTextField();
		textField_516.setForeground(Color.LIGHT_GRAY);
		textField_516.addMouseListener(this);
		textField_516.setText("6");
		textField_516.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_516.setColumns(10);
		textField_516.setBounds(285, 290, 20, 20);
		add(textField_516);
		
		textField_497 = new JTextField();
		textField_497.setForeground(Color.LIGHT_GRAY);
		textField_497.addMouseListener(this);
		textField_497.setText("7");
		textField_497.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_497.setColumns(10);
		textField_497.setBounds(175, 305, 20, 20);
		add(textField_497);
		
		textField_498 = new JTextField();
		textField_498.setForeground(Color.LIGHT_GRAY);
		textField_498.addMouseListener(this);
		textField_498.setText("8");
		textField_498.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_498.setColumns(10);
		textField_498.setBounds(188, 305, 20, 20);
		add(textField_498);
		
		textField_499 = new JTextField();
		textField_499.setForeground(Color.LIGHT_GRAY);
		textField_499.addMouseListener(this);
		textField_499.setText("9");
		textField_499.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_499.setColumns(10);
		textField_499.setBounds(201, 305, 20, 20);
		add(textField_499);
		
		textField_507 = new JTextField();
		textField_507.setForeground(Color.LIGHT_GRAY);
		textField_507.addMouseListener(this);
		textField_507.setText("7");
		textField_507.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_507.setColumns(10);
		textField_507.setBounds(217, 305, 20, 20);
		add(textField_507);
		
		textField_508 = new JTextField();
		textField_508.setForeground(Color.LIGHT_GRAY);
		textField_508.addMouseListener(this);
		textField_508.setText("8");
		textField_508.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_508.setColumns(10);
		textField_508.setBounds(230, 305, 20, 20);
		add(textField_508);
		
		textField_509 = new JTextField();
		textField_509.setForeground(Color.LIGHT_GRAY);
		textField_509.addMouseListener(this);
		textField_509.setText("9");
		textField_509.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_509.setColumns(10);
		textField_509.setBounds(243, 305, 20, 20);
		add(textField_509);
		
		textField_517 = new JTextField();
		textField_517.setForeground(Color.LIGHT_GRAY);
		textField_517.addMouseListener(this);
		textField_517.setText("7");
		textField_517.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_517.setColumns(10);
		textField_517.setBounds(259, 305, 20, 20);
		add(textField_517);
		
		textField_518 = new JTextField();
		textField_518.setForeground(Color.LIGHT_GRAY);
		textField_518.addMouseListener(this);
		textField_518.setText("8");
		textField_518.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_518.setColumns(10);
		textField_518.setBounds(272, 305, 20, 20);
		add(textField_518);
		
		textField_519 = new JTextField();
		textField_519.setForeground(Color.LIGHT_GRAY);
		textField_519.addMouseListener(this);
		textField_519.setText("9");
		textField_519.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_519.setColumns(10);
		textField_519.setBounds(285, 305, 20, 20);
		add(textField_519);
		
		textField_341 = new JTextField();
		textField_341.setForeground(Color.LIGHT_GRAY);
		textField_341.addMouseListener(this);
		textField_341.setText("1");
		textField_341.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_341.setColumns(10);
		textField_341.setBounds(304, 179, 20, 20);
		add(textField_341);
		
		textField_342 = new JTextField();
		textField_342.setForeground(Color.LIGHT_GRAY);
		textField_342.addMouseListener(this);
		textField_342.setText("2");
		textField_342.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_342.setColumns(10);
		textField_342.setBounds(317, 179, 20, 20);
		add(textField_342);
		
		textField_343 = new JTextField();
		textField_343.setForeground(Color.LIGHT_GRAY);
		textField_343.addMouseListener(this);
		textField_343.setText("3");
		textField_343.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_343.setColumns(10);
		textField_343.setBounds(330, 179, 20, 20);
		add(textField_343);
		
		textField_351 = new JTextField();
		textField_351.setForeground(Color.LIGHT_GRAY);
		textField_351.addMouseListener(this);
		textField_351.setText("1");
		textField_351.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_351.setColumns(10);
		textField_351.setBounds(346, 179, 20, 20);
		add(textField_351);
		
		textField_352 = new JTextField();
		textField_352.setForeground(Color.LIGHT_GRAY);
		textField_352.addMouseListener(this);
		textField_352.setText("2");
		textField_352.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_352.setColumns(10);
		textField_352.setBounds(359, 179, 20, 20);
		add(textField_352);
		
		textField_353 = new JTextField();
		textField_353.setForeground(Color.LIGHT_GRAY);
		textField_353.addMouseListener(this);
		textField_353.setText("3");
		textField_353.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_353.setColumns(10);
		textField_353.setBounds(372, 179, 20, 20);
		add(textField_353);
		
		textField_361 = new JTextField();
		textField_361.setForeground(Color.LIGHT_GRAY);
		textField_361.addMouseListener(this);
		textField_361.setText("1");
		textField_361.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_361.setColumns(10);
		textField_361.setBounds(388, 179, 20, 20);
		add(textField_361);
		
		textField_362 = new JTextField();
		textField_362.setForeground(Color.LIGHT_GRAY);
		textField_362.addMouseListener(this);
		textField_362.setText("2");
		textField_362.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_362.setColumns(10);
		textField_362.setBounds(401, 179, 20, 20);
		add(textField_362);
		
		textField_363 = new JTextField();
		textField_363.setForeground(Color.LIGHT_GRAY);
		textField_363.addMouseListener(this);
		textField_363.setText("3");
		textField_363.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_363.setColumns(10);
		textField_363.setBounds(414, 179, 20, 20);
		add(textField_363);
		
		textField_344 = new JTextField();
		textField_344.setForeground(Color.LIGHT_GRAY);
		textField_344.addMouseListener(this);
		textField_344.setText("4");
		textField_344.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_344.setColumns(10);
		textField_344.setBounds(304, 194, 20, 20);
		add(textField_344);
		
		textField_345 = new JTextField();
		textField_345.setForeground(Color.LIGHT_GRAY);
		textField_345.addMouseListener(this);
		textField_345.setText("5");
		textField_345.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_345.setColumns(10);
		textField_345.setBounds(317, 194, 20, 20);
		add(textField_345);
		
		textField_346 = new JTextField();
		textField_346.setForeground(Color.LIGHT_GRAY);
		textField_346.addMouseListener(this);
		textField_346.setText("6");
		textField_346.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_346.setColumns(10);
		textField_346.setBounds(330, 194, 20, 20);
		add(textField_346);
		
		textField_354 = new JTextField();
		textField_354.setForeground(Color.LIGHT_GRAY);
		textField_354.addMouseListener(this);
		textField_354.setText("4");
		textField_354.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_354.setColumns(10);
		textField_354.setBounds(346, 194, 20, 20);
		add(textField_354);
		
		textField_355 = new JTextField();
		textField_355.setForeground(Color.LIGHT_GRAY);
		textField_355.addMouseListener(this);
		textField_355.setText("5");
		textField_355.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_355.setColumns(10);
		textField_355.setBounds(359, 194, 20, 20);
		add(textField_355);
		
		textField_356 = new JTextField();
		textField_356.setForeground(Color.LIGHT_GRAY);
		textField_356.addMouseListener(this);
		textField_356.setText("6");
		textField_356.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_356.setColumns(10);
		textField_356.setBounds(372, 194, 20, 20);
		add(textField_356);
		
		textField_364 = new JTextField();
		textField_364.setForeground(Color.LIGHT_GRAY);
		textField_364.addMouseListener(this);
		textField_364.setText("4");
		textField_364.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_364.setColumns(10);
		textField_364.setBounds(388, 194, 20, 20);
		add(textField_364);
		
		textField_365 = new JTextField();
		textField_365.setForeground(Color.LIGHT_GRAY);
		textField_365.addMouseListener(this);
		textField_365.setText("5");
		textField_365.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_365.setColumns(10);
		textField_365.setBounds(401, 194, 20, 20);
		add(textField_365);
		
		textField_366 = new JTextField();
		textField_366.setForeground(Color.LIGHT_GRAY);
		textField_366.addMouseListener(this);
		textField_366.setText("6");
		textField_366.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_366.setColumns(10);
		textField_366.setBounds(414, 194, 20, 20);
		add(textField_366);
		
		textField_347 = new JTextField();
		textField_347.setForeground(Color.LIGHT_GRAY);
		textField_347.addMouseListener(this);
		textField_347.setText("7");
		textField_347.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_347.setColumns(10);
		textField_347.setBounds(304, 209, 20, 20);
		add(textField_347);
		
		textField_348 = new JTextField();
		textField_348.setForeground(Color.LIGHT_GRAY);
		textField_348.addMouseListener(this);
		textField_348.setText("8");
		textField_348.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_348.setColumns(10);
		textField_348.setBounds(317, 209, 20, 20);
		add(textField_348);
		
		textField_349 = new JTextField();
		textField_349.setForeground(Color.LIGHT_GRAY);
		textField_349.addMouseListener(this);
		textField_349.setText("9");
		textField_349.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_349.setColumns(10);
		textField_349.setBounds(330, 209, 20, 20);
		add(textField_349);
		
		textField_357 = new JTextField();
		textField_357.setForeground(Color.LIGHT_GRAY);
		textField_357.addMouseListener(this);
		textField_357.setText("7");
		textField_357.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_357.setColumns(10);
		textField_357.setBounds(346, 209, 20, 20);
		add(textField_357);
		
		textField_358 = new JTextField();
		textField_358.setForeground(Color.LIGHT_GRAY);
		textField_358.addMouseListener(this);
		textField_358.setText("8");
		textField_358.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_358.setColumns(10);
		textField_358.setBounds(359, 209, 20, 20);
		add(textField_358);
		
		textField_359 = new JTextField();
		textField_359.setForeground(Color.LIGHT_GRAY);
		textField_359.addMouseListener(this);
		textField_359.setText("9");
		textField_359.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_359.setColumns(10);
		textField_359.setBounds(372, 209, 20, 20);
		add(textField_359);
		
		textField_367 = new JTextField();
		textField_367.setForeground(Color.LIGHT_GRAY);
		textField_367.addMouseListener(this);
		textField_367.setText("7");
		textField_367.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_367.setColumns(10);
		textField_367.setBounds(388, 209, 20, 20);
		add(textField_367);
		
		textField_369 = new JTextField();
		textField_369.setForeground(Color.LIGHT_GRAY);
		textField_369.addMouseListener(this);
		textField_369.setText("9");
		textField_369.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_369.setColumns(10);
		textField_369.setBounds(414, 209, 20, 20);
		add(textField_369);
		
		textField_368 = new JTextField();
		textField_368.setForeground(Color.LIGHT_GRAY);
		textField_368.addMouseListener(this);
		textField_368.setText("8");
		textField_368.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_368.setColumns(10);
		textField_368.setBounds(401, 209, 20, 20);
		add(textField_368);
		
		textField_431 = new JTextField();
		textField_431.setForeground(Color.LIGHT_GRAY);
		textField_431.addMouseListener(this);
		textField_431.setText("1");
		textField_431.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_431.setColumns(10);
		textField_431.setBounds(304, 227, 20, 20);
		add(textField_431);
		
		textField_432 = new JTextField();
		textField_432.setForeground(Color.LIGHT_GRAY);
		textField_432.addMouseListener(this);
		textField_432.setText("2");
		textField_432.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_432.setColumns(10);
		textField_432.setBounds(317, 227, 20, 20);
		add(textField_432);
		
		textField_433 = new JTextField();
		textField_433.setForeground(Color.LIGHT_GRAY);
		textField_433.addMouseListener(this);
		textField_433.setText("3");
		textField_433.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_433.setColumns(10);
		textField_433.setBounds(330, 227, 20, 20);
		add(textField_433);
		
		textField_441 = new JTextField();
		textField_441.setForeground(Color.LIGHT_GRAY);
		textField_441.addMouseListener(this);
		textField_441.setText("1");
		textField_441.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_441.setColumns(10);
		textField_441.setBounds(346, 227, 20, 20);
		add(textField_441);
		
		textField_442 = new JTextField();
		textField_442.setForeground(Color.LIGHT_GRAY);
		textField_442.addMouseListener(this);
		textField_442.setText("2");
		textField_442.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_442.setColumns(10);
		textField_442.setBounds(359, 227, 20, 20);
		add(textField_442);
		
		textField_443 = new JTextField();
		textField_443.setForeground(Color.LIGHT_GRAY);
		textField_443.addMouseListener(this);
		textField_443.setText("3");
		textField_443.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_443.setColumns(10);
		textField_443.setBounds(372, 227, 20, 20);
		add(textField_443);
		
		textField_451 = new JTextField();
		textField_451.setForeground(Color.LIGHT_GRAY);
		textField_451.addMouseListener(this);
		textField_451.setText("1");
		textField_451.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_451.setColumns(10);
		textField_451.setBounds(388, 227, 20, 20);
		add(textField_451);
		
		textField_452 = new JTextField();
		textField_452.setForeground(Color.LIGHT_GRAY);
		textField_452.addMouseListener(this);
		textField_452.setText("2");
		textField_452.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_452.setColumns(10);
		textField_452.setBounds(401, 227, 20, 20);
		add(textField_452);
		
		textField_453 = new JTextField();
		textField_453.setForeground(Color.LIGHT_GRAY);
		textField_453.addMouseListener(this);
		textField_453.setText("3");
		textField_453.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_453.setColumns(10);
		textField_453.setBounds(414, 227, 20, 20);
		add(textField_453);
		
		textField_434 = new JTextField();
		textField_434.setForeground(Color.LIGHT_GRAY);
		textField_434.addMouseListener(this);
		textField_434.setText("4");
		textField_434.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_434.setColumns(10);
		textField_434.setBounds(304, 242, 20, 20);
		add(textField_434);
		
		textField_435 = new JTextField();
		textField_435.setForeground(Color.LIGHT_GRAY);
		textField_435.addMouseListener(this);
		textField_435.setText("5");
		textField_435.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_435.setColumns(10);
		textField_435.setBounds(317, 242, 20, 20);
		add(textField_435);
		
		textField_436 = new JTextField();
		textField_436.setForeground(Color.LIGHT_GRAY);
		textField_436.addMouseListener(this);
		textField_436.setText("6");
		textField_436.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_436.setColumns(10);
		textField_436.setBounds(330, 242, 20, 20);
		add(textField_436);
		
		textField_444 = new JTextField();
		textField_444.setForeground(Color.LIGHT_GRAY);
		textField_444.addMouseListener(this);
		textField_444.setText("4");
		textField_444.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_444.setColumns(10);
		textField_444.setBounds(346, 242, 20, 20);
		add(textField_444);
		
		textField_445 = new JTextField();
		textField_445.setForeground(Color.LIGHT_GRAY);
		textField_445.addMouseListener(this);
		textField_445.setText("5");
		textField_445.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_445.setColumns(10);
		textField_445.setBounds(359, 242, 20, 20);
		add(textField_445);
		
		textField_446 = new JTextField();
		textField_446.setForeground(Color.LIGHT_GRAY);
		textField_446.addMouseListener(this);
		textField_446.setText("6");
		textField_446.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_446.setColumns(10);
		textField_446.setBounds(372, 242, 20, 20);
		add(textField_446);
		
		textField_454 = new JTextField();
		textField_454.setForeground(Color.LIGHT_GRAY);
		textField_454.addMouseListener(this);
		textField_454.setText("4");
		textField_454.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_454.setColumns(10);
		textField_454.setBounds(388, 242, 20, 20);
		add(textField_454);
		
		textField_455 = new JTextField();
		textField_455.setForeground(Color.LIGHT_GRAY);
		textField_455.addMouseListener(this);
		textField_455.setText("5");
		textField_455.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_455.setColumns(10);
		textField_455.setBounds(401, 242, 20, 20);
		add(textField_455);
		
		textField_456 = new JTextField();
		textField_456.setForeground(Color.LIGHT_GRAY);
		textField_456.addMouseListener(this);
		textField_456.setText("6");
		textField_456.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_456.setColumns(10);
		textField_456.setBounds(414, 242, 20, 20);
		add(textField_456);
		
		textField_437 = new JTextField();
		textField_437.setForeground(Color.LIGHT_GRAY);
		textField_437.addMouseListener(this);
		textField_437.setText("7");
		textField_437.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_437.setColumns(10);
		textField_437.setBounds(304, 257, 20, 20);
		add(textField_437);
		
		textField_438 = new JTextField();
		textField_438.setForeground(Color.LIGHT_GRAY);
		textField_438.addMouseListener(this);
		textField_438.setText("8");
		textField_438.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_438.setColumns(10);
		textField_438.setBounds(317, 257, 20, 20);
		add(textField_438);
		
		textField_439 = new JTextField();
		textField_439.setForeground(Color.LIGHT_GRAY);
		textField_439.addMouseListener(this);
		textField_439.setText("9");
		textField_439.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_439.setColumns(10);
		textField_439.setBounds(330, 257, 20, 20);
		add(textField_439);
		
		textField_447 = new JTextField();
		textField_447.setForeground(Color.LIGHT_GRAY);
		textField_447.addMouseListener(this);
		textField_447.setText("7");
		textField_447.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_447.setColumns(10);
		textField_447.setBounds(346, 257, 20, 20);
		add(textField_447);
		
		textField_448 = new JTextField();
		textField_448.setForeground(Color.LIGHT_GRAY);
		textField_448.addMouseListener(this);
		textField_448.setText("8");
		textField_448.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_448.setColumns(10);
		textField_448.setBounds(359, 257, 20, 20);
		add(textField_448);
		
		textField_449 = new JTextField();
		textField_449.setForeground(Color.LIGHT_GRAY);
		textField_449.addMouseListener(this);
		textField_449.setText("9");
		textField_449.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_449.setColumns(10);
		textField_449.setBounds(372, 257, 20, 20);
		add(textField_449);
		
		textField_457 = new JTextField();
		textField_457.setForeground(Color.LIGHT_GRAY);
		textField_457.addMouseListener(this);
		textField_457.setText("7");
		textField_457.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_457.setColumns(10);
		textField_457.setBounds(388, 257, 20, 20);
		add(textField_457);
		
		textField_458 = new JTextField();
		textField_458.setForeground(Color.LIGHT_GRAY);
		textField_458.addMouseListener(this);
		textField_458.setText("8");
		textField_458.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_458.setColumns(10);
		textField_458.setBounds(401, 257, 20, 20);
		add(textField_458);
		
		textField_459 = new JTextField();
		textField_459.setForeground(Color.LIGHT_GRAY);
		textField_459.addMouseListener(this);
		textField_459.setText("9");
		textField_459.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_459.setColumns(10);
		textField_459.setBounds(414, 257, 20, 20);
		add(textField_459);
		
		textField_521 = new JTextField();
		textField_521.setForeground(Color.LIGHT_GRAY);
		textField_521.addMouseListener(this);
		textField_521.setText("1");
		textField_521.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_521.setColumns(10);
		textField_521.setBounds(304, 275, 20, 20);
		add(textField_521);
		
		textField_522 = new JTextField();
		textField_522.setForeground(Color.LIGHT_GRAY);
		textField_522.addMouseListener(this);
		textField_522.setText("2");
		textField_522.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_522.setColumns(10);
		textField_522.setBounds(317, 275, 20, 20);
		add(textField_522);
		
		textField_523 = new JTextField();
		textField_523.setForeground(Color.LIGHT_GRAY);
		textField_523.addMouseListener(this);
		textField_523.setText("3");
		textField_523.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_523.setColumns(10);
		textField_523.setBounds(330, 275, 20, 20);
		add(textField_523);
		
		textField_531 = new JTextField();
		textField_531.setForeground(Color.LIGHT_GRAY);
		textField_531.addMouseListener(this);
		textField_531.setText("1");
		textField_531.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_531.setColumns(10);
		textField_531.setBounds(346, 275, 20, 20);
		add(textField_531);
		
		textField_532 = new JTextField();
		textField_532.setForeground(Color.LIGHT_GRAY);
		textField_532.addMouseListener(this);
		textField_532.setText("2");
		textField_532.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_532.setColumns(10);
		textField_532.setBounds(359, 275, 20, 20);
		add(textField_532);
		
		textField_533 = new JTextField();
		textField_533.setForeground(Color.LIGHT_GRAY);
		textField_533.addMouseListener(this);
		textField_533.setText("3");
		textField_533.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_533.setColumns(10);
		textField_533.setBounds(372, 275, 20, 20);
		add(textField_533);
		
		textField_541 = new JTextField();
		textField_541.setForeground(Color.LIGHT_GRAY);
		textField_541.addMouseListener(this);
		textField_541.setText("1");
		textField_541.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_541.setColumns(10);
		textField_541.setBounds(388, 275, 20, 20);
		add(textField_541);
		
		textField_542 = new JTextField();
		textField_542.setForeground(Color.LIGHT_GRAY);
		textField_542.addMouseListener(this);
		textField_542.setText("2");
		textField_542.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_542.setColumns(10);
		textField_542.setBounds(401, 275, 20, 20);
		add(textField_542);
		
		textField_543 = new JTextField();
		textField_543.setForeground(Color.LIGHT_GRAY);
		textField_543.addMouseListener(this);
		textField_543.setText("3");
		textField_543.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_543.setColumns(10);
		textField_543.setBounds(414, 275, 20, 20);
		add(textField_543);
		
		textField_524 = new JTextField();
		textField_524.setForeground(Color.LIGHT_GRAY);
		textField_524.addMouseListener(this);
		textField_524.setText("4");
		textField_524.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_524.setColumns(10);
		textField_524.setBounds(304, 290, 20, 20);
		add(textField_524);
		
		textField_525 = new JTextField();
		textField_525.setForeground(Color.LIGHT_GRAY);
		textField_525.addMouseListener(this);
		textField_525.setText("5");
		textField_525.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_525.setColumns(10);
		textField_525.setBounds(317, 290, 20, 20);
		add(textField_525);
		
		textField_526 = new JTextField();
		textField_526.setForeground(Color.LIGHT_GRAY);
		textField_526.addMouseListener(this);
		textField_526.setText("6");
		textField_526.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_526.setColumns(10);
		textField_526.setBounds(330, 290, 20, 20);
		add(textField_526);
		
		textField_534 = new JTextField();
		textField_534.setForeground(Color.LIGHT_GRAY);
		textField_534.addMouseListener(this);
		textField_534.setText("4");
		textField_534.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_534.setColumns(10);
		textField_534.setBounds(346, 290, 20, 20);
		add(textField_534);
		
		textField_535 = new JTextField();
		textField_535.setForeground(Color.LIGHT_GRAY);
		textField_535.addMouseListener(this);
		textField_535.setText("5");
		textField_535.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_535.setColumns(10);
		textField_535.setBounds(359, 290, 20, 20);
		add(textField_535);
		
		textField_536 = new JTextField();
		textField_536.setForeground(Color.LIGHT_GRAY);
		textField_536.addMouseListener(this);
		textField_536.setText("6");
		textField_536.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_536.setColumns(10);
		textField_536.setBounds(372, 290, 20, 20);
		add(textField_536);
		
		textField_544 = new JTextField();
		textField_544.setForeground(Color.LIGHT_GRAY);
		textField_544.addMouseListener(this);
		textField_544.setText("4");
		textField_544.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_544.setColumns(10);
		textField_544.setBounds(388, 290, 20, 20);
		add(textField_544);
		
		textField_545 = new JTextField();
		textField_545.setForeground(Color.LIGHT_GRAY);
		textField_545.addMouseListener(this);
		textField_545.setText("5");
		textField_545.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_545.setColumns(10);
		textField_545.setBounds(401, 290, 20, 20);
		add(textField_545);
		
		textField_546 = new JTextField();
		textField_546.setForeground(Color.LIGHT_GRAY);
		textField_546.addMouseListener(this);
		textField_546.setText("6");
		textField_546.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_546.setColumns(10);
		textField_546.setBounds(414, 290, 20, 20);
		add(textField_546);
		
		textField_527 = new JTextField();
		textField_527.setForeground(Color.LIGHT_GRAY);
		textField_527.addMouseListener(this);
		textField_527.setText("7");
		textField_527.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_527.setColumns(10);
		textField_527.setBounds(304, 305, 20, 20);
		add(textField_527);
		
		textField_528 = new JTextField();
		textField_528.setForeground(Color.LIGHT_GRAY);
		textField_528.addMouseListener(this);
		textField_528.setText("8");
		textField_528.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_528.setColumns(10);
		textField_528.setBounds(317, 305, 20, 20);
		add(textField_528);
		
		textField_529 = new JTextField();
		textField_529.setForeground(Color.LIGHT_GRAY);
		textField_529.addMouseListener(this);
		textField_529.setText("9");
		textField_529.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_529.setColumns(10);
		textField_529.setBounds(330, 305, 20, 20);
		add(textField_529);
		
		textField_537 = new JTextField();
		textField_537.setForeground(Color.LIGHT_GRAY);
		textField_537.addMouseListener(this);
		textField_537.setText("7");
		textField_537.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_537.setColumns(10);
		textField_537.setBounds(346, 305, 20, 20);
		add(textField_537);
		
		textField_538 = new JTextField();
		textField_538.setForeground(Color.LIGHT_GRAY);
		textField_538.addMouseListener(this);
		textField_538.setText("8");
		textField_538.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_538.setColumns(10);
		textField_538.setBounds(359, 305, 20, 20);
		add(textField_538);
		
		textField_539 = new JTextField();
		textField_539.setForeground(Color.LIGHT_GRAY);
		textField_539.addMouseListener(this);
		textField_539.setText("9");
		textField_539.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_539.setColumns(10);
		textField_539.setBounds(372, 305, 20, 20);
		add(textField_539);
		
		textField_547 = new JTextField();
		textField_547.setForeground(Color.LIGHT_GRAY);
		textField_547.addMouseListener(this);
		textField_547.setText("7");
		textField_547.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_547.setColumns(10);
		textField_547.setBounds(388, 305, 20, 20);
		add(textField_547);
		
		textField_548 = new JTextField();
		textField_548.setForeground(Color.LIGHT_GRAY);
		textField_548.addMouseListener(this);
		textField_548.setText("8");
		textField_548.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_548.setColumns(10);
		textField_548.setBounds(401, 305, 20, 20);
		add(textField_548);
		
		textField_549 = new JTextField();
		textField_549.setForeground(Color.LIGHT_GRAY);
		textField_549.addMouseListener(this);
		textField_549.setText("9");
		textField_549.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_549.setColumns(10);
		textField_549.setBounds(414, 305, 20, 20);
		add(textField_549);
		
		textField_551 = new JTextField();
		textField_551.setForeground(Color.LIGHT_GRAY);
		textField_551.addMouseListener(this);
		textField_551.setText("1");
		textField_551.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_551.setColumns(10);
		textField_551.setBounds(46, 327, 20, 20);
		add(textField_551);
		
		textField_552 = new JTextField();
		textField_552.setForeground(Color.LIGHT_GRAY);
		textField_552.addMouseListener(this);
		textField_552.setText("2");
		textField_552.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_552.setColumns(10);
		textField_552.setBounds(59, 327, 20, 20);
		add(textField_552);
		
		textField_553 = new JTextField();
		textField_553.setForeground(Color.LIGHT_GRAY);
		textField_553.addMouseListener(this);
		textField_553.setText("3");
		textField_553.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_553.setColumns(10);
		textField_553.setBounds(72, 327, 20, 20);
		add(textField_553);
		
		textField_561 = new JTextField();
		textField_561.setForeground(Color.LIGHT_GRAY);
		textField_561.addMouseListener(this);
		textField_561.setText("1");
		textField_561.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_561.setColumns(10);
		textField_561.setBounds(88, 327, 20, 20);
		add(textField_561);
		
		textField_562 = new JTextField();
		textField_562.setForeground(Color.LIGHT_GRAY);
		textField_562.addMouseListener(this);
		textField_562.setText("2");
		textField_562.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_562.setColumns(10);
		textField_562.setBounds(101, 327, 20, 20);
		add(textField_562);
		
		textField_563 = new JTextField();
		textField_563.setForeground(Color.LIGHT_GRAY);
		textField_563.addMouseListener(this);
		textField_563.setText("3");
		textField_563.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_563.setColumns(10);
		textField_563.setBounds(114, 327, 20, 20);
		add(textField_563);
		
		textField_571 = new JTextField();
		textField_571.setForeground(Color.LIGHT_GRAY);
		textField_571.addMouseListener(this);
		textField_571.setText("1");
		textField_571.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_571.setColumns(10);
		textField_571.setBounds(130, 327, 20, 20);
		add(textField_571);
		
		textField_572 = new JTextField();
		textField_572.setForeground(Color.LIGHT_GRAY);
		textField_572.addMouseListener(this);
		textField_572.setText("2");
		textField_572.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_572.setColumns(10);
		textField_572.setBounds(143, 327, 20, 20);
		add(textField_572);
		
		textField_573 = new JTextField();
		textField_573.setForeground(Color.LIGHT_GRAY);
		textField_573.addMouseListener(this);
		textField_573.setText("3");
		textField_573.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_573.setColumns(10);
		textField_573.setBounds(156, 327, 20, 20);
		add(textField_573);
		
		textField_554 = new JTextField();
		textField_554.setForeground(Color.LIGHT_GRAY);
		textField_554.addMouseListener(this);
		textField_554.setText("4");
		textField_554.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_554.setColumns(10);
		textField_554.setBounds(46, 342, 20, 20);
		add(textField_554);
		
		textField_555 = new JTextField();
		textField_555.setForeground(Color.LIGHT_GRAY);
		textField_555.addMouseListener(this);
		textField_555.setText("5");
		textField_555.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_555.setColumns(10);
		textField_555.setBounds(59, 342, 20, 20);
		add(textField_555);
		
		textField_556 = new JTextField();
		textField_556.setForeground(Color.LIGHT_GRAY);
		textField_556.addMouseListener(this);
		textField_556.setText("6");
		textField_556.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_556.setColumns(10);
		textField_556.setBounds(72, 342, 20, 20);
		add(textField_556);
		
		textField_564 = new JTextField();
		textField_564.setForeground(Color.LIGHT_GRAY);
		textField_564.addMouseListener(this);
		textField_564.setText("4");
		textField_564.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_564.setColumns(10);
		textField_564.setBounds(88, 342, 20, 20);
		add(textField_564);
		
		textField_565 = new JTextField();
		textField_565.setForeground(Color.LIGHT_GRAY);
		textField_565.addMouseListener(this);
		textField_565.setText("5");
		textField_565.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_565.setColumns(10);
		textField_565.setBounds(101, 342, 20, 20);
		add(textField_565);
		
		textField_566 = new JTextField();
		textField_566.setForeground(Color.LIGHT_GRAY);
		textField_566.addMouseListener(this);
		textField_566.setText("6");
		textField_566.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_566.setColumns(10);
		textField_566.setBounds(114, 342, 20, 20);
		add(textField_566);
		
		textField_574 = new JTextField();
		textField_574.setForeground(Color.LIGHT_GRAY);
		textField_574.addMouseListener(this);
		textField_574.setText("4");
		textField_574.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_574.setColumns(10);
		textField_574.setBounds(130, 342, 20, 20);
		add(textField_574);
		
		textField_575 = new JTextField();
		textField_575.setForeground(Color.LIGHT_GRAY);
		textField_575.addMouseListener(this);
		textField_575.setText("5");
		textField_575.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_575.setColumns(10);
		textField_575.setBounds(143, 342, 20, 20);
		add(textField_575);
		
		textField_576 = new JTextField();
		textField_576.setForeground(Color.LIGHT_GRAY);
		textField_576.addMouseListener(this);
		textField_576.setText("6");
		textField_576.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_576.setColumns(10);
		textField_576.setBounds(156, 342, 20, 20);
		add(textField_576);
		
		textField_557 = new JTextField();
		textField_557.setForeground(Color.LIGHT_GRAY);
		textField_557.addMouseListener(this);
		textField_557.setText("7");
		textField_557.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_557.setColumns(10);
		textField_557.setBounds(46, 357, 20, 20);
		add(textField_557);
		
		textField_558 = new JTextField();
		textField_558.setForeground(Color.LIGHT_GRAY);
		textField_558.addMouseListener(this);
		textField_558.setText("8");
		textField_558.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_558.setColumns(10);
		textField_558.setBounds(59, 357, 20, 20);
		add(textField_558);
		
		textField_559 = new JTextField();
		textField_559.setForeground(Color.LIGHT_GRAY);
		textField_559.addMouseListener(this);
		textField_559.setText("9");
		textField_559.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_559.setColumns(10);
		textField_559.setBounds(72, 357, 20, 20);
		add(textField_559);
		
		textField_567 = new JTextField();
		textField_567.setForeground(Color.LIGHT_GRAY);
		textField_567.addMouseListener(this);
		textField_567.setText("7");
		textField_567.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_567.setColumns(10);
		textField_567.setBounds(88, 357, 20, 20);
		add(textField_567);
		
		textField_568 = new JTextField();
		textField_568.setForeground(Color.LIGHT_GRAY);
		textField_568.addMouseListener(this);
		textField_568.setText("8");
		textField_568.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_568.setColumns(10);
		textField_568.setBounds(101, 357, 20, 20);
		add(textField_568);
		
		textField_569 = new JTextField();
		textField_569.setForeground(Color.LIGHT_GRAY);
		textField_569.addMouseListener(this);
		textField_569.setText("9");
		textField_569.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_569.setColumns(10);
		textField_569.setBounds(114, 357, 20, 20);
		add(textField_569);
		
		textField_577 = new JTextField();
		textField_577.setForeground(Color.LIGHT_GRAY);
		textField_577.addMouseListener(this);
		textField_577.setText("7");
		textField_577.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_577.setColumns(10);
		textField_577.setBounds(130, 357, 20, 20);
		add(textField_577);
		
		textField_579 = new JTextField();
		textField_579.setForeground(Color.LIGHT_GRAY);
		textField_579.addMouseListener(this);
		textField_579.setText("9");
		textField_579.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_579.setColumns(10);
		textField_579.setBounds(156, 357, 20, 20);
		add(textField_579);
		
		textField_578 = new JTextField();
		textField_578.setForeground(Color.LIGHT_GRAY);
		textField_578.addMouseListener(this);
		textField_578.setText("8");
		textField_578.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_578.setColumns(10);
		textField_578.setBounds(143, 357, 20, 20);
		add(textField_578);
		
		textField_641 = new JTextField();
		textField_641.setForeground(Color.LIGHT_GRAY);
		textField_641.addMouseListener(this);
		textField_641.setText("1");
		textField_641.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_641.setColumns(10);
		textField_641.setBounds(46, 375, 20, 20);
		add(textField_641);
		
		textField_642 = new JTextField();
		textField_642.setForeground(Color.LIGHT_GRAY);
		textField_642.addMouseListener(this);
		textField_642.setText("2");
		textField_642.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_642.setColumns(10);
		textField_642.setBounds(59, 375, 20, 20);
		add(textField_642);
		
		textField_643 = new JTextField();
		textField_643.setForeground(Color.LIGHT_GRAY);
		textField_643.addMouseListener(this);
		textField_643.setText("3");
		textField_643.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_643.setColumns(10);
		textField_643.setBounds(72, 375, 20, 20);
		add(textField_643);
		
		textField_651 = new JTextField();
		textField_651.setForeground(Color.LIGHT_GRAY);
		textField_651.addMouseListener(this);
		textField_651.setText("1");
		textField_651.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_651.setColumns(10);
		textField_651.setBounds(88, 375, 20, 20);
		add(textField_651);
		
		textField_652 = new JTextField();
		textField_652.setForeground(Color.LIGHT_GRAY);
		textField_652.addMouseListener(this);
		textField_652.setText("2");
		textField_652.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_652.setColumns(10);
		textField_652.setBounds(101, 375, 20, 20);
		add(textField_652);
		
		textField_653 = new JTextField();
		textField_653.setForeground(Color.LIGHT_GRAY);
		textField_653.addMouseListener(this);
		textField_653.setText("3");
		textField_653.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_653.setColumns(10);
		textField_653.setBounds(114, 375, 20, 20);
		add(textField_653);
		
		textField_661 = new JTextField();
		textField_661.setForeground(Color.LIGHT_GRAY);
		textField_661.addMouseListener(this);
		textField_661.setText("1");
		textField_661.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_661.setColumns(10);
		textField_661.setBounds(130, 375, 20, 20);
		add(textField_661);
		
		textField_662 = new JTextField();
		textField_662.setForeground(Color.LIGHT_GRAY);
		textField_662.addMouseListener(this);
		textField_662.setText("2");
		textField_662.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_662.setColumns(10);
		textField_662.setBounds(143, 375, 20, 20);
		add(textField_662);
		
		textField_663 = new JTextField();
		textField_663.setForeground(Color.LIGHT_GRAY);
		textField_663.addMouseListener(this);
		textField_663.setText("3");
		textField_663.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_663.setColumns(10);
		textField_663.setBounds(156, 375, 20, 20);
		add(textField_663);
		
		textField_644 = new JTextField();
		textField_644.setForeground(Color.LIGHT_GRAY);
		textField_644.addMouseListener(this);
		textField_644.setText("4");
		textField_644.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_644.setColumns(10);
		textField_644.setBounds(46, 390, 20, 20);
		add(textField_644);
		
		textField_645 = new JTextField();
		textField_645.setForeground(Color.LIGHT_GRAY);
		textField_645.addMouseListener(this);
		textField_645.setText("5");
		textField_645.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_645.setColumns(10);
		textField_645.setBounds(59, 390, 20, 20);
		add(textField_645);
		
		textField_646 = new JTextField();
		textField_646.setForeground(Color.LIGHT_GRAY);
		textField_646.addMouseListener(this);
		textField_646.setText("6");
		textField_646.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_646.setColumns(10);
		textField_646.setBounds(72, 390, 20, 20);
		add(textField_646);
		
		textField_654 = new JTextField();
		textField_654.setForeground(Color.LIGHT_GRAY);
		textField_654.addMouseListener(this);
		textField_654.setText("4");
		textField_654.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_654.setColumns(10);
		textField_654.setBounds(88, 390, 20, 20);
		add(textField_654);
		
		textField_655 = new JTextField();
		textField_655.setForeground(Color.LIGHT_GRAY);
		textField_655.addMouseListener(this);
		textField_655.setText("5");
		textField_655.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_655.setColumns(10);
		textField_655.setBounds(101, 390, 20, 20);
		add(textField_655);
		
		textField_656 = new JTextField();
		textField_656.setForeground(Color.LIGHT_GRAY);
		textField_656.addMouseListener(this);
		textField_656.setText("6");
		textField_656.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_656.setColumns(10);
		textField_656.setBounds(114, 390, 20, 20);
		add(textField_656);
		
		textField_664 = new JTextField();
		textField_664.setForeground(Color.LIGHT_GRAY);
		textField_664.addMouseListener(this);
		textField_664.setText("4");
		textField_664.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_664.setColumns(10);
		textField_664.setBounds(130, 390, 20, 20);
		add(textField_664);
		
		textField_665 = new JTextField();
		textField_665.setForeground(Color.LIGHT_GRAY);
		textField_665.addMouseListener(this);
		textField_665.setText("5");
		textField_665.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_665.setColumns(10);
		textField_665.setBounds(143, 390, 20, 20);
		add(textField_665);
		
		textField_666 = new JTextField();
		textField_666.setForeground(Color.LIGHT_GRAY);
		textField_666.addMouseListener(this);
		textField_666.setText("6");
		textField_666.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_666.setColumns(10);
		textField_666.setBounds(156, 390, 20, 20);
		add(textField_666);
		
		textField_647 = new JTextField();
		textField_647.setForeground(Color.LIGHT_GRAY);
		textField_647.addMouseListener(this);
		textField_647.setText("7");
		textField_647.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_647.setColumns(10);
		textField_647.setBounds(46, 405, 20, 20);
		add(textField_647);
		
		textField_648 = new JTextField();
		textField_648.setForeground(Color.LIGHT_GRAY);
		textField_648.addMouseListener(this);
		textField_648.setText("8");
		textField_648.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_648.setColumns(10);
		textField_648.setBounds(59, 405, 20, 20);
		add(textField_648);
		
		textField_649 = new JTextField();
		textField_649.setForeground(Color.LIGHT_GRAY);
		textField_649.addMouseListener(this);
		textField_649.setText("9");
		textField_649.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_649.setColumns(10);
		textField_649.setBounds(72, 405, 20, 20);
		add(textField_649);
		
		textField_657 = new JTextField();
		textField_657.setForeground(Color.LIGHT_GRAY);
		textField_657.addMouseListener(this);
		textField_657.setText("7");
		textField_657.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_657.setColumns(10);
		textField_657.setBounds(88, 405, 20, 20);
		add(textField_657);
		
		textField_658 = new JTextField();
		textField_658.setForeground(Color.LIGHT_GRAY);
		textField_658.addMouseListener(this);
		textField_658.setText("8");
		textField_658.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_658.setColumns(10);
		textField_658.setBounds(101, 405, 20, 20);
		add(textField_658);
		
		textField_659 = new JTextField();
		textField_659.setForeground(Color.LIGHT_GRAY);
		textField_659.addMouseListener(this);
		textField_659.setText("9");
		textField_659.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_659.setColumns(10);
		textField_659.setBounds(114, 405, 20, 20);
		add(textField_659);
		
		textField_667 = new JTextField();
		textField_667.setForeground(Color.LIGHT_GRAY);
		textField_667.addMouseListener(this);
		textField_667.setText("7");
		textField_667.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_667.setColumns(10);
		textField_667.setBounds(130, 405, 20, 20);
		add(textField_667);
		
		textField_668 = new JTextField();
		textField_668.setForeground(Color.LIGHT_GRAY);
		textField_668.addMouseListener(this);
		textField_668.setText("8");
		textField_668.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_668.setColumns(10);
		textField_668.setBounds(143, 405, 20, 20);
		add(textField_668);
		
		textField_669 = new JTextField();
		textField_669.setForeground(Color.LIGHT_GRAY);
		textField_669.addMouseListener(this);
		textField_669.setText("9");
		textField_669.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_669.setColumns(10);
		textField_669.setBounds(156, 405, 20, 20);
		add(textField_669);
		
		textField_731 = new JTextField();
		textField_731.setForeground(Color.LIGHT_GRAY);
		textField_731.addMouseListener(this);
		textField_731.setText("1");
		textField_731.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_731.setColumns(10);
		textField_731.setBounds(46, 423, 20, 20);
		add(textField_731);
		
		textField_732 = new JTextField();
		textField_732.setForeground(Color.LIGHT_GRAY);
		textField_732.addMouseListener(this);
		textField_732.setText("2");
		textField_732.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_732.setColumns(10);
		textField_732.setBounds(59, 423, 20, 20);
		add(textField_732);
		
		textField_733 = new JTextField();
		textField_733.setForeground(Color.LIGHT_GRAY);
		textField_733.addMouseListener(this);
		textField_733.setText("3");
		textField_733.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_733.setColumns(10);
		textField_733.setBounds(72, 423, 20, 20);
		add(textField_733);
		
		textField_741 = new JTextField();
		textField_741.setForeground(Color.LIGHT_GRAY);
		textField_741.addMouseListener(this);
		textField_741.setText("1");
		textField_741.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_741.setColumns(10);
		textField_741.setBounds(88, 423, 20, 20);
		add(textField_741);
		
		textField_742 = new JTextField();
		textField_742.setForeground(Color.LIGHT_GRAY);
		textField_742.addMouseListener(this);
		textField_742.setText("2");
		textField_742.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_742.setColumns(10);
		textField_742.setBounds(101, 423, 20, 20);
		add(textField_742);
		
		textField_743 = new JTextField();
		textField_743.setForeground(Color.LIGHT_GRAY);
		textField_743.addMouseListener(this);
		textField_743.setText("3");
		textField_743.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_743.setColumns(10);
		textField_743.setBounds(114, 423, 20, 20);
		add(textField_743);
		
		textField_751 = new JTextField();
		textField_751.setForeground(Color.LIGHT_GRAY);
		textField_751.addMouseListener(this);
		textField_751.setText("1");
		textField_751.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_751.setColumns(10);
		textField_751.setBounds(130, 423, 20, 20);
		add(textField_751);
		
		textField_752 = new JTextField();
		textField_752.setForeground(Color.LIGHT_GRAY);
		textField_752.addMouseListener(this);
		textField_752.setText("2");
		textField_752.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_752.setColumns(10);
		textField_752.setBounds(143, 423, 20, 20);
		add(textField_752);
		
		textField_753 = new JTextField();
		textField_753.setForeground(Color.LIGHT_GRAY);
		textField_753.addMouseListener(this);
		textField_753.setText("3");
		textField_753.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_753.setColumns(10);
		textField_753.setBounds(156, 423, 20, 20);
		add(textField_753);
		
		textField_734 = new JTextField();
		textField_734.setForeground(Color.LIGHT_GRAY);
		textField_734.addMouseListener(this);
		textField_734.setText("4");
		textField_734.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_734.setColumns(10);
		textField_734.setBounds(46, 438, 20, 20);
		add(textField_734);
		
		textField_735 = new JTextField();
		textField_735.setForeground(Color.LIGHT_GRAY);
		textField_735.addMouseListener(this);
		textField_735.setText("5");
		textField_735.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_735.setColumns(10);
		textField_735.setBounds(59, 438, 20, 20);
		add(textField_735);
		
		textField_736 = new JTextField();
		textField_736.setForeground(Color.LIGHT_GRAY);
		textField_736.addMouseListener(this);
		textField_736.setText("6");
		textField_736.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_736.setColumns(10);
		textField_736.setBounds(72, 438, 20, 20);
		add(textField_736);
		
		textField_744 = new JTextField();
		textField_744.setForeground(Color.LIGHT_GRAY);
		textField_744.addMouseListener(this);
		textField_744.setText("4");
		textField_744.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_744.setColumns(10);
		textField_744.setBounds(88, 438, 20, 20);
		add(textField_744);
		
		textField_745 = new JTextField();
		textField_745.setForeground(Color.LIGHT_GRAY);
		textField_745.addMouseListener(this);
		textField_745.setText("5");
		textField_745.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_745.setColumns(10);
		textField_745.setBounds(101, 438, 20, 20);
		add(textField_745);
		
		textField_746 = new JTextField();
		textField_746.setForeground(Color.LIGHT_GRAY);
		textField_746.addMouseListener(this);
		textField_746.setText("6");
		textField_746.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_746.setColumns(10);
		textField_746.setBounds(114, 438, 20, 20);
		add(textField_746);
		
		textField_754 = new JTextField();
		textField_754.setForeground(Color.LIGHT_GRAY);
		textField_754.addMouseListener(this);
		textField_754.setText("4");
		textField_754.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_754.setColumns(10);
		textField_754.setBounds(130, 438, 20, 20);
		add(textField_754);
		
		textField_755 = new JTextField();
		textField_755.setForeground(Color.LIGHT_GRAY);
		textField_755.addMouseListener(this);
		textField_755.setText("5");
		textField_755.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_755.setColumns(10);
		textField_755.setBounds(143, 438, 20, 20);
		add(textField_755);
		
		textField_756 = new JTextField();
		textField_756.setForeground(Color.LIGHT_GRAY);
		textField_756.addMouseListener(this);
		textField_756.setText("6");
		textField_756.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_756.setColumns(10);
		textField_756.setBounds(156, 438, 20, 20);
		add(textField_756);
		
		textField_737 = new JTextField();
		textField_737.setForeground(Color.LIGHT_GRAY);
		textField_737.addMouseListener(this);
		textField_737.setText("7");
		textField_737.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_737.setColumns(10);
		textField_737.setBounds(46, 453, 20, 20);
		add(textField_737);
		
		textField_738 = new JTextField();
		textField_738.setForeground(Color.LIGHT_GRAY);
		textField_738.addMouseListener(this);
		textField_738.setText("8");
		textField_738.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_738.setColumns(10);
		textField_738.setBounds(59, 453, 20, 20);
		add(textField_738);
		
		textField_739 = new JTextField();
		textField_739.setForeground(Color.LIGHT_GRAY);
		textField_739.addMouseListener(this);
		textField_739.setText("9");
		textField_739.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_739.setColumns(10);
		textField_739.setBounds(72, 453, 20, 20);
		add(textField_739);
		
		textField_747 = new JTextField();
		textField_747.setForeground(Color.LIGHT_GRAY);
		textField_747.addMouseListener(this);
		textField_747.setText("7");
		textField_747.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_747.setColumns(10);
		textField_747.setBounds(88, 453, 20, 20);
		add(textField_747);
		
		textField_748 = new JTextField();
		textField_748.setForeground(Color.LIGHT_GRAY);
		textField_748.addMouseListener(this);
		textField_748.setText("8");
		textField_748.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_748.setColumns(10);
		textField_748.setBounds(101, 453, 20, 20);
		add(textField_748);
		
		textField_749 = new JTextField();
		textField_749.setForeground(Color.LIGHT_GRAY);
		textField_749.addMouseListener(this);
		textField_749.setText("9");
		textField_749.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_749.setColumns(10);
		textField_749.setBounds(114, 453, 20, 20);
		add(textField_749);
		
		textField_757 = new JTextField();
		textField_757.setForeground(Color.LIGHT_GRAY);
		textField_757.addMouseListener(this);
		textField_757.setText("7");
		textField_757.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_757.setColumns(10);
		textField_757.setBounds(130, 453, 20, 20);
		add(textField_757);
		
		textField_758 = new JTextField();
		textField_758.setForeground(Color.LIGHT_GRAY);
		textField_758.addMouseListener(this);
		textField_758.setText("8");
		textField_758.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_758.setColumns(10);
		textField_758.setBounds(143, 453, 20, 20);
		add(textField_758);
		
		textField_759 = new JTextField();
		textField_759.setForeground(Color.LIGHT_GRAY);
		textField_759.addMouseListener(this);
		textField_759.setText("9");
		textField_759.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_759.setColumns(10);
		textField_759.setBounds(156, 453, 20, 20);
		add(textField_759);
		
		textField_581 = new JTextField();
		textField_581.setForeground(Color.LIGHT_GRAY);
		textField_581.addMouseListener(this);
		textField_581.setText("1");
		textField_581.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_581.setColumns(10);
		textField_581.setBounds(175, 327, 20, 20);
		add(textField_581);
		
		textField_582 = new JTextField();
		textField_582.setForeground(Color.LIGHT_GRAY);
		textField_582.addMouseListener(this);
		textField_582.setText("2");
		textField_582.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_582.setColumns(10);
		textField_582.setBounds(188, 327, 20, 20);
		add(textField_582);
		
		textField_583 = new JTextField();
		textField_583.setForeground(Color.LIGHT_GRAY);
		textField_583.addMouseListener(this);
		textField_583.setText("3");
		textField_583.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_583.setColumns(10);
		textField_583.setBounds(201, 327, 20, 20);
		add(textField_583);
		
		textField_591 = new JTextField();
		textField_591.setForeground(Color.LIGHT_GRAY);
		textField_591.addMouseListener(this);
		textField_591.setText("1");
		textField_591.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_591.setColumns(10);
		textField_591.setBounds(217, 327, 20, 20);
		add(textField_591);
		
		textField_592 = new JTextField();
		textField_592.setForeground(Color.LIGHT_GRAY);
		textField_592.addMouseListener(this);
		textField_592.setText("2");
		textField_592.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_592.setColumns(10);
		textField_592.setBounds(230, 327, 20, 20);
		add(textField_592);
		
		textField_593 = new JTextField();
		textField_593.setForeground(Color.LIGHT_GRAY);
		textField_593.addMouseListener(this);
		textField_593.setText("3");
		textField_593.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_593.setColumns(10);
		textField_593.setBounds(243, 327, 20, 20);
		add(textField_593);
		
		textField_601 = new JTextField();
		textField_601.setForeground(Color.LIGHT_GRAY);
		textField_601.addMouseListener(this);
		textField_601.setText("1");
		textField_601.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_601.setColumns(10);
		textField_601.setBounds(259, 327, 20, 20);
		add(textField_601);
		
		textField_602 = new JTextField();
		textField_602.setForeground(Color.LIGHT_GRAY);
		textField_602.addMouseListener(this);
		textField_602.setText("2");
		textField_602.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_602.setColumns(10);
		textField_602.setBounds(272, 327, 20, 20);
		add(textField_602);
		
		textField_603 = new JTextField();
		textField_603.setForeground(Color.LIGHT_GRAY);
		textField_603.addMouseListener(this);
		textField_603.setText("3");
		textField_603.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_603.setColumns(10);
		textField_603.setBounds(285, 327, 20, 20);
		add(textField_603);
		
		textField_584 = new JTextField();
		textField_584.setForeground(Color.LIGHT_GRAY);
		textField_584.addMouseListener(this);
		textField_584.setText("4");
		textField_584.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_584.setColumns(10);
		textField_584.setBounds(175, 342, 20, 20);
		add(textField_584);
		
		textField_585 = new JTextField();
		textField_585.setForeground(Color.LIGHT_GRAY);
		textField_585.addMouseListener(this);
		textField_585.setText("5");
		textField_585.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_585.setColumns(10);
		textField_585.setBounds(188, 342, 20, 20);
		add(textField_585);
		
		textField_586 = new JTextField();
		textField_586.setForeground(Color.LIGHT_GRAY);
		textField_586.addMouseListener(this);
		textField_586.setText("6");
		textField_586.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_586.setColumns(10);
		textField_586.setBounds(201, 342, 20, 20);
		add(textField_586);
		
		textField_594 = new JTextField();
		textField_594.setForeground(Color.LIGHT_GRAY);
		textField_594.addMouseListener(this);
		textField_594.setText("4");
		textField_594.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_594.setColumns(10);
		textField_594.setBounds(217, 342, 20, 20);
		add(textField_594);
		
		textField_595 = new JTextField();
		textField_595.setForeground(Color.LIGHT_GRAY);
		textField_595.addMouseListener(this);
		textField_595.setText("5");
		textField_595.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_595.setColumns(10);
		textField_595.setBounds(230, 342, 20, 20);
		add(textField_595);
		
		textField_596 = new JTextField();
		textField_596.setForeground(Color.LIGHT_GRAY);
		textField_596.addMouseListener(this);
		textField_596.setText("6");
		textField_596.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_596.setColumns(10);
		textField_596.setBounds(243, 342, 20, 20);
		add(textField_596);
		
		textField_604 = new JTextField();
		textField_604.setForeground(Color.LIGHT_GRAY);
		textField_604.addMouseListener(this);
		textField_604.setText("4");
		textField_604.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_604.setColumns(10);
		textField_604.setBounds(259, 342, 20, 20);
		add(textField_604);
		
		textField_605 = new JTextField();
		textField_605.setForeground(Color.LIGHT_GRAY);
		textField_605.addMouseListener(this);
		textField_605.setText("5");
		textField_605.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_605.setColumns(10);
		textField_605.setBounds(272, 342, 20, 20);
		add(textField_605);
		
		textField_606 = new JTextField();
		textField_606.setForeground(Color.LIGHT_GRAY);
		textField_606.addMouseListener(this);
		textField_606.setText("6");
		textField_606.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_606.setColumns(10);
		textField_606.setBounds(285, 342, 20, 20);
		add(textField_606);
		
		textField_587 = new JTextField();
		textField_587.setForeground(Color.LIGHT_GRAY);
		textField_587.addMouseListener(this);
		textField_587.setText("7");
		textField_587.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_587.setColumns(10);
		textField_587.setBounds(175, 357, 20, 20);
		add(textField_587);
		
		textField_588 = new JTextField();
		textField_588.setForeground(Color.LIGHT_GRAY);
		textField_588.addMouseListener(this);
		textField_588.setText("8");
		textField_588.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_588.setColumns(10);
		textField_588.setBounds(188, 357, 20, 20);
		add(textField_588);
		
		textField_589 = new JTextField();
		textField_589.setForeground(Color.LIGHT_GRAY);
		textField_589.addMouseListener(this);
		textField_589.setText("9");
		textField_589.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_589.setColumns(10);
		textField_589.setBounds(201, 357, 20, 20);
		add(textField_589);
		
		textField_597 = new JTextField();
		textField_597.setForeground(Color.LIGHT_GRAY);
		textField_597.addMouseListener(this);
		textField_597.setText("7");
		textField_597.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_597.setColumns(10);
		textField_597.setBounds(217, 357, 20, 20);
		add(textField_597);
		
		textField_598 = new JTextField();
		textField_598.setForeground(Color.LIGHT_GRAY);
		textField_598.addMouseListener(this);
		textField_598.setText("8");
		textField_598.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_598.setColumns(10);
		textField_598.setBounds(230, 357, 20, 20);
		add(textField_598);
		
		textField_599 = new JTextField();
		textField_599.setForeground(Color.LIGHT_GRAY);
		textField_599.addMouseListener(this);
		textField_599.setText("9");
		textField_599.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_599.setColumns(10);
		textField_599.setBounds(243, 357, 20, 20);
		add(textField_599);
		
		textField_607 = new JTextField();
		textField_607.setForeground(Color.LIGHT_GRAY);
		textField_607.addMouseListener(this);
		textField_607.setText("7");
		textField_607.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_607.setColumns(10);
		textField_607.setBounds(259, 357, 20, 20);
		add(textField_607);
		
		textField_609 = new JTextField();
		textField_609.setForeground(Color.LIGHT_GRAY);
		textField_609.addMouseListener(this);
		textField_609.setText("9");
		textField_609.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_609.setColumns(10);
		textField_609.setBounds(285, 357, 20, 20);
		add(textField_609);
		
		textField_608 = new JTextField();
		textField_608.setForeground(Color.LIGHT_GRAY);
		textField_608.addMouseListener(this);
		textField_608.setText("8");
		textField_608.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_608.setColumns(10);
		textField_608.setBounds(272, 357, 20, 20);
		add(textField_608);
		
		textField_671 = new JTextField();
		textField_671.setForeground(Color.LIGHT_GRAY);
		textField_671.addMouseListener(this);
		textField_671.setText("1");
		textField_671.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_671.setColumns(10);
		textField_671.setBounds(175, 375, 20, 20);
		add(textField_671);
		
		textField_672 = new JTextField();
		textField_672.setForeground(Color.LIGHT_GRAY);
		textField_672.addMouseListener(this);
		textField_672.setText("2");
		textField_672.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_672.setColumns(10);
		textField_672.setBounds(188, 375, 20, 20);
		add(textField_672);
		
		textField_673 = new JTextField();
		textField_673.setForeground(Color.LIGHT_GRAY);
		textField_673.addMouseListener(this);
		textField_673.setText("3");
		textField_673.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_673.setColumns(10);
		textField_673.setBounds(201, 375, 20, 20);
		add(textField_673);
		
		textField_681 = new JTextField();
		textField_681.setForeground(Color.LIGHT_GRAY);
		textField_681.addMouseListener(this);
		textField_681.setText("1");
		textField_681.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_681.setColumns(10);
		textField_681.setBounds(217, 375, 20, 20);
		add(textField_681);
		
		textField_682 = new JTextField();
		textField_682.setForeground(Color.LIGHT_GRAY);
		textField_682.addMouseListener(this);
		textField_682.setText("2");
		textField_682.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_682.setColumns(10);
		textField_682.setBounds(230, 375, 20, 20);
		add(textField_682);
		
		textField_683 = new JTextField();
		textField_683.setForeground(Color.LIGHT_GRAY);
		textField_683.addMouseListener(this);
		textField_683.setText("3");
		textField_683.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_683.setColumns(10);
		textField_683.setBounds(243, 375, 20, 20);
		add(textField_683);
		
		textField_691 = new JTextField();
		textField_691.setForeground(Color.LIGHT_GRAY);
		textField_691.addMouseListener(this);
		textField_691.setText("1");
		textField_691.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_691.setColumns(10);
		textField_691.setBounds(259, 375, 20, 20);
		add(textField_691);
		
		textField_692 = new JTextField();
		textField_692.setForeground(Color.LIGHT_GRAY);
		textField_692.addMouseListener(this);
		textField_692.setText("2");
		textField_692.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_692.setColumns(10);
		textField_692.setBounds(272, 375, 20, 20);
		add(textField_692);
		
		textField_693 = new JTextField();
		textField_693.setForeground(Color.LIGHT_GRAY);
		textField_693.addMouseListener(this);
		textField_693.setText("3");
		textField_693.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_693.setColumns(10);
		textField_693.setBounds(285, 375, 20, 20);
		add(textField_693);
		
		textField_674 = new JTextField();
		textField_674.setForeground(Color.LIGHT_GRAY);
		textField_674.addMouseListener(this);
		textField_674.setText("4");
		textField_674.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_674.setColumns(10);
		textField_674.setBounds(175, 390, 20, 20);
		add(textField_674);
		
		textField_675 = new JTextField();
		textField_675.setForeground(Color.LIGHT_GRAY);
		textField_675.addMouseListener(this);
		textField_675.setText("5");
		textField_675.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_675.setColumns(10);
		textField_675.setBounds(188, 390, 20, 20);
		add(textField_675);
		
		textField_676 = new JTextField();
		textField_676.setForeground(Color.LIGHT_GRAY);
		textField_676.addMouseListener(this);
		textField_676.setText("6");
		textField_676.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_676.setColumns(10);
		textField_676.setBounds(201, 390, 20, 20);
		add(textField_676);
		
		textField_684 = new JTextField();
		textField_684.setForeground(Color.LIGHT_GRAY);
		textField_684.addMouseListener(this);
		textField_684.setText("4");
		textField_684.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_684.setColumns(10);
		textField_684.setBounds(217, 390, 20, 20);
		add(textField_684);
		
		textField_685 = new JTextField();
		textField_685.setForeground(Color.LIGHT_GRAY);
		textField_685.addMouseListener(this);
		textField_685.setText("5");
		textField_685.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_685.setColumns(10);
		textField_685.setBounds(230, 390, 20, 20);
		add(textField_685);
		
		textField_686 = new JTextField();
		textField_686.setForeground(Color.LIGHT_GRAY);
		textField_686.addMouseListener(this);
		textField_686.setText("6");
		textField_686.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_686.setColumns(10);
		textField_686.setBounds(243, 390, 20, 20);
		add(textField_686);
		
		textField_694 = new JTextField();
		textField_694.setForeground(Color.LIGHT_GRAY);
		textField_694.addMouseListener(this);
		textField_694.setText("4");
		textField_694.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_694.setColumns(10);
		textField_694.setBounds(259, 390, 20, 20);
		add(textField_694);
		
		textField_695 = new JTextField();
		textField_695.setForeground(Color.LIGHT_GRAY);
		textField_695.addMouseListener(this);
		textField_695.setText("5");
		textField_695.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_695.setColumns(10);
		textField_695.setBounds(272, 390, 20, 20);
		add(textField_695);
		
		textField_696 = new JTextField();
		textField_696.setForeground(Color.LIGHT_GRAY);
		textField_696.addMouseListener(this);
		textField_696.setText("6");
		textField_696.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_696.setColumns(10);
		textField_696.setBounds(285, 390, 20, 20);
		add(textField_696);
		
		textField_677 = new JTextField();
		textField_677.setForeground(Color.LIGHT_GRAY);
		textField_677.addMouseListener(this);
		textField_677.setText("7");
		textField_677.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_677.setColumns(10);
		textField_677.setBounds(175, 405, 20, 20);
		add(textField_677);
		
		textField_678 = new JTextField();
		textField_678.setForeground(Color.LIGHT_GRAY);
		textField_678.addMouseListener(this);
		textField_678.setText("8");
		textField_678.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_678.setColumns(10);
		textField_678.setBounds(188, 405, 20, 20);
		add(textField_678);
		
		textField_679 = new JTextField();
		textField_679.setForeground(Color.LIGHT_GRAY);
		textField_679.addMouseListener(this);
		textField_679.setText("9");
		textField_679.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_679.setColumns(10);
		textField_679.setBounds(201, 405, 20, 20);
		add(textField_679);
		
		textField_687 = new JTextField();
		textField_687.setForeground(Color.LIGHT_GRAY);
		textField_687.addMouseListener(this);
		textField_687.setText("7");
		textField_687.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_687.setColumns(10);
		textField_687.setBounds(217, 405, 20, 20);
		add(textField_687);
		
		textField_688 = new JTextField();
		textField_688.setForeground(Color.LIGHT_GRAY);
		textField_688.addMouseListener(this);
		textField_688.setText("8");
		textField_688.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_688.setColumns(10);
		textField_688.setBounds(230, 405, 20, 20);
		add(textField_688);
		
		textField_689 = new JTextField();
		textField_689.setForeground(Color.LIGHT_GRAY);
		textField_689.addMouseListener(this);
		textField_689.setText("9");
		textField_689.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_689.setColumns(10);
		textField_689.setBounds(243, 405, 20, 20);
		add(textField_689);
		
		textField_697 = new JTextField();
		textField_697.setForeground(Color.LIGHT_GRAY);
		textField_697.addMouseListener(this);
		textField_697.setText("7");
		textField_697.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_697.setColumns(10);
		textField_697.setBounds(259, 405, 20, 20);
		add(textField_697);
		
		textField_698 = new JTextField();
		textField_698.setForeground(Color.LIGHT_GRAY);
		textField_698.addMouseListener(this);
		textField_698.setText("8");
		textField_698.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_698.setColumns(10);
		textField_698.setBounds(272, 405, 20, 20);
		add(textField_698);
		
		textField_699 = new JTextField();
		textField_699.setForeground(Color.LIGHT_GRAY);
		textField_699.addMouseListener(this);
		textField_699.setText("9");
		textField_699.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_699.setColumns(10);
		textField_699.setBounds(285, 405, 20, 20);
		add(textField_699);
		
		textField_761 = new JTextField();
		textField_761.setForeground(Color.LIGHT_GRAY);
		textField_761.addMouseListener(this);
		textField_761.setText("1");
		textField_761.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_761.setColumns(10);
		textField_761.setBounds(175, 423, 20, 20);
		add(textField_761);
		
		textField_762 = new JTextField();
		textField_762.setForeground(Color.LIGHT_GRAY);
		textField_762.addMouseListener(this);
		textField_762.setText("2");
		textField_762.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_762.setColumns(10);
		textField_762.setBounds(188, 423, 20, 20);
		add(textField_762);
		
		textField_763 = new JTextField();
		textField_763.setForeground(Color.LIGHT_GRAY);
		textField_763.addMouseListener(this);
		textField_763.setText("3");
		textField_763.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_763.setColumns(10);
		textField_763.setBounds(201, 423, 20, 20);
		add(textField_763);
		
		textField_771 = new JTextField();
		textField_771.setForeground(Color.LIGHT_GRAY);
		textField_771.addMouseListener(this);
		textField_771.setText("1");
		textField_771.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_771.setColumns(10);
		textField_771.setBounds(217, 423, 20, 20);
		add(textField_771);
		
		textField_772 = new JTextField();
		textField_772.setForeground(Color.LIGHT_GRAY);
		textField_772.addMouseListener(this);
		textField_772.setText("2");
		textField_772.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_772.setColumns(10);
		textField_772.setBounds(230, 423, 20, 20);
		add(textField_772);
		
		textField_773 = new JTextField();
		textField_773.setForeground(Color.LIGHT_GRAY);
		textField_773.addMouseListener(this);
		textField_773.setText("3");
		textField_773.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_773.setColumns(10);
		textField_773.setBounds(243, 423, 20, 20);
		add(textField_773);
		
		textField_781 = new JTextField();
		textField_781.setForeground(Color.LIGHT_GRAY);
		textField_781.addMouseListener(this);
		textField_781.setText("1");
		textField_781.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_781.setColumns(10);
		textField_781.setBounds(259, 423, 20, 20);
		add(textField_781);
		
		textField_782 = new JTextField();
		textField_782.setForeground(Color.LIGHT_GRAY);
		textField_782.addMouseListener(this);
		textField_782.setText("2");
		textField_782.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_782.setColumns(10);
		textField_782.setBounds(272, 423, 20, 20);
		add(textField_782);
		
		textField_783 = new JTextField();
		textField_783.setForeground(Color.LIGHT_GRAY);
		textField_783.addMouseListener(this);
		textField_783.setText("3");
		textField_783.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_783.setColumns(10);
		textField_783.setBounds(285, 423, 20, 20);
		add(textField_783);
		
		textField_764 = new JTextField();
		textField_764.setForeground(Color.LIGHT_GRAY);
		textField_764.addMouseListener(this);
		textField_764.setText("4");
		textField_764.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_764.setColumns(10);
		textField_764.setBounds(175, 438, 20, 20);
		add(textField_764);
		
		textField_765 = new JTextField();
		textField_765.setForeground(Color.LIGHT_GRAY);
		textField_765.addMouseListener(this);
		textField_765.setText("5");
		textField_765.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_765.setColumns(10);
		textField_765.setBounds(188, 438, 20, 20);
		add(textField_765);
		
		textField_766 = new JTextField();
		textField_766.setForeground(Color.LIGHT_GRAY);
		textField_766.addMouseListener(this);
		textField_766.setText("6");
		textField_766.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_766.setColumns(10);
		textField_766.setBounds(201, 438, 20, 20);
		add(textField_766);
		
		textField_774 = new JTextField();
		textField_774.setForeground(Color.LIGHT_GRAY);
		textField_774.addMouseListener(this);
		textField_774.setText("4");
		textField_774.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_774.setColumns(10);
		textField_774.setBounds(217, 438, 20, 20);
		add(textField_774);
		
		textField_775 = new JTextField();
		textField_775.setForeground(Color.LIGHT_GRAY);
		textField_775.addMouseListener(this);
		textField_775.setText("5");
		textField_775.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_775.setColumns(10);
		textField_775.setBounds(230, 438, 20, 20);
		add(textField_775);
		
		textField_776 = new JTextField();
		textField_776.setForeground(Color.LIGHT_GRAY);
		textField_776.addMouseListener(this);
		textField_776.setText("6");
		textField_776.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_776.setColumns(10);
		textField_776.setBounds(243, 438, 20, 20);
		add(textField_776);
		
		textField_784 = new JTextField();
		textField_784.setForeground(Color.LIGHT_GRAY);
		textField_784.addMouseListener(this);
		textField_784.setText("4");
		textField_784.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_784.setColumns(10);
		textField_784.setBounds(259, 438, 20, 20);
		add(textField_784);
		
		textField_785 = new JTextField();
		textField_785.setForeground(Color.LIGHT_GRAY);
		textField_785.addMouseListener(this);
		textField_785.setText("5");
		textField_785.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_785.setColumns(10);
		textField_785.setBounds(272, 438, 20, 20);
		add(textField_785);
		
		textField_786 = new JTextField();
		textField_786.setForeground(Color.LIGHT_GRAY);
		textField_786.addMouseListener(this);
		textField_786.setText("6");
		textField_786.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_786.setColumns(10);
		textField_786.setBounds(285, 438, 20, 20);
		add(textField_786);
		
		textField_767 = new JTextField();
		textField_767.setForeground(Color.LIGHT_GRAY);
		textField_767.addMouseListener(this);
		textField_767.setText("7");
		textField_767.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_767.setColumns(10);
		textField_767.setBounds(175, 453, 20, 20);
		add(textField_767);
		
		textField_768 = new JTextField();
		textField_768.setForeground(Color.LIGHT_GRAY);
		textField_768.addMouseListener(this);
		textField_768.setText("8");
		textField_768.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_768.setColumns(10);
		textField_768.setBounds(188, 453, 20, 20);
		add(textField_768);
		
		textField_769 = new JTextField();
		textField_769.setForeground(Color.LIGHT_GRAY);
		textField_769.addMouseListener(this);
		textField_769.setText("9");
		textField_769.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_769.setColumns(10);
		textField_769.setBounds(201, 453, 20, 20);
		add(textField_769);
		
		textField_777 = new JTextField();
		textField_777.setForeground(Color.LIGHT_GRAY);
		textField_777.addMouseListener(this);
		textField_777.setText("7");
		textField_777.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_777.setColumns(10);
		textField_777.setBounds(217, 453, 20, 20);
		add(textField_777);
		
		textField_778 = new JTextField();
		textField_778.setForeground(Color.LIGHT_GRAY);
		textField_778.addMouseListener(this);
		textField_778.setText("8");
		textField_778.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_778.setColumns(10);
		textField_778.setBounds(230, 453, 20, 20);
		add(textField_778);
		
		textField_779 = new JTextField();
		textField_779.setForeground(Color.LIGHT_GRAY);
		textField_779.addMouseListener(this);
		textField_779.setText("9");
		textField_779.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_779.setColumns(10);
		textField_779.setBounds(243, 453, 20, 20);
		add(textField_779);
		
		textField_787 = new JTextField();
		textField_787.setForeground(Color.LIGHT_GRAY);
		textField_787.addMouseListener(this);
		textField_787.setText("7");
		textField_787.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_787.setColumns(10);
		textField_787.setBounds(259, 453, 20, 20);
		add(textField_787);
		
		textField_788 = new JTextField();
		textField_788.setForeground(Color.LIGHT_GRAY);
		textField_788.addMouseListener(this);
		textField_788.setText("8");
		textField_788.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_788.setColumns(10);
		textField_788.setBounds(272, 453, 20, 20);
		add(textField_788);
		
		textField_789 = new JTextField();
		textField_789.setForeground(Color.LIGHT_GRAY);
		textField_789.addMouseListener(this);
		textField_789.setText("9");
		textField_789.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_789.setColumns(10);
		textField_789.setBounds(285, 453, 20, 20);
		add(textField_789);
		
		textField_611 = new JTextField();
		textField_611.setForeground(Color.LIGHT_GRAY);
		textField_611.addMouseListener(this);
		textField_611.setText("1");
		textField_611.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_611.setColumns(10);
		textField_611.setBounds(304, 327, 20, 20);
		add(textField_611);
		
		textField_612 = new JTextField();
		textField_612.setForeground(Color.LIGHT_GRAY);
		textField_612.addMouseListener(this);
		textField_612.setText("2");
		textField_612.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_612.setColumns(10);
		textField_612.setBounds(317, 327, 20, 20);
		add(textField_612);
		
		textField_613 = new JTextField();
		textField_613.setForeground(Color.LIGHT_GRAY);
		textField_613.addMouseListener(this);
		textField_613.setText("3");
		textField_613.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_613.setColumns(10);
		textField_613.setBounds(330, 327, 20, 20);
		add(textField_613);
		
		textField_621 = new JTextField();
		textField_621.setForeground(Color.LIGHT_GRAY);
		textField_621.addMouseListener(this);
		textField_621.setText("1");
		textField_621.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_621.setColumns(10);
		textField_621.setBounds(346, 327, 20, 20);
		add(textField_621);
		
		textField_622 = new JTextField();
		textField_622.setForeground(Color.LIGHT_GRAY);
		textField_622.addMouseListener(this);
		textField_622.setText("2");
		textField_622.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_622.setColumns(10);
		textField_622.setBounds(359, 327, 20, 20);
		add(textField_622);
		
		textField_623 = new JTextField();
		textField_623.setForeground(Color.LIGHT_GRAY);
		textField_623.addMouseListener(this);
		textField_623.setText("3");
		textField_623.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_623.setColumns(10);
		textField_623.setBounds(372, 327, 20, 20);
		add(textField_623);
		
		textField_631 = new JTextField();
		textField_631.setForeground(Color.LIGHT_GRAY);
		textField_631.addMouseListener(this);
		textField_631.setText("1");
		textField_631.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_631.setColumns(10);
		textField_631.setBounds(388, 327, 20, 20);
		add(textField_631);
		
		textField_632 = new JTextField();
		textField_632.setForeground(Color.LIGHT_GRAY);
		textField_632.addMouseListener(this);
		textField_632.setText("2");
		textField_632.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_632.setColumns(10);
		textField_632.setBounds(401, 327, 20, 20);
		add(textField_632);
		
		textField_633 = new JTextField();
		textField_633.setForeground(Color.LIGHT_GRAY);
		textField_633.addMouseListener(this);
		textField_633.setText("3");
		textField_633.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_633.setColumns(10);
		textField_633.setBounds(414, 327, 20, 20);
		add(textField_633);
		
		textField_614 = new JTextField();
		textField_614.setForeground(Color.LIGHT_GRAY);
		textField_614.addMouseListener(this);
		textField_614.setText("4");
		textField_614.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_614.setColumns(10);
		textField_614.setBounds(304, 342, 20, 20);
		add(textField_614);
		
		textField_615 = new JTextField();
		textField_615.setForeground(Color.LIGHT_GRAY);
		textField_615.addMouseListener(this);
		textField_615.setText("5");
		textField_615.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_615.setColumns(10);
		textField_615.setBounds(317, 342, 20, 20);
		add(textField_615);
		
		textField_616 = new JTextField();
		textField_616.setForeground(Color.LIGHT_GRAY);
		textField_616.addMouseListener(this);
		textField_616.setText("6");
		textField_616.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_616.setColumns(10);
		textField_616.setBounds(330, 342, 20, 20);
		add(textField_616);
		
		textField_624 = new JTextField();
		textField_624.setForeground(Color.LIGHT_GRAY);
		textField_624.addMouseListener(this);
		textField_624.setText("4");
		textField_624.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_624.setColumns(10);
		textField_624.setBounds(346, 342, 20, 20);
		add(textField_624);
		
		textField_625 = new JTextField();
		textField_625.setForeground(Color.LIGHT_GRAY);
		textField_625.addMouseListener(this);
		textField_625.setText("5");
		textField_625.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_625.setColumns(10);
		textField_625.setBounds(359, 342, 20, 20);
		add(textField_625);
		
		textField_626 = new JTextField();
		textField_626.setForeground(Color.LIGHT_GRAY);
		textField_626.addMouseListener(this);
		textField_626.setText("6");
		textField_626.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_626.setColumns(10);
		textField_626.setBounds(372, 342, 20, 20);
		add(textField_626);
		
		textField_634 = new JTextField();
		textField_634.setForeground(Color.LIGHT_GRAY);
		textField_634.addMouseListener(this);
		textField_634.setText("4");
		textField_634.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_634.setColumns(10);
		textField_634.setBounds(388, 342, 20, 20);
		add(textField_634);
		
		textField_635 = new JTextField();
		textField_635.setForeground(Color.LIGHT_GRAY);
		textField_635.addMouseListener(this);
		textField_635.setText("5");
		textField_635.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_635.setColumns(10);
		textField_635.setBounds(401, 342, 20, 20);
		add(textField_635);
		
		textField_636 = new JTextField();
		textField_636.setForeground(Color.LIGHT_GRAY);
		textField_636.addMouseListener(this);
		textField_636.setText("6");
		textField_636.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_636.setColumns(10);
		textField_636.setBounds(414, 342, 20, 20);
		add(textField_636);
		
		textField_617 = new JTextField();
		textField_617.setForeground(Color.LIGHT_GRAY);
		textField_617.addMouseListener(this);
		textField_617.setText("7");
		textField_617.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_617.setColumns(10);
		textField_617.setBounds(304, 357, 20, 20);
		add(textField_617);
		
		textField_618 = new JTextField();
		textField_618.setForeground(Color.LIGHT_GRAY);
		textField_618.addMouseListener(this);
		textField_618.setText("8");
		textField_618.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_618.setColumns(10);
		textField_618.setBounds(317, 357, 20, 20);
		add(textField_618);
		
		textField_619 = new JTextField();
		textField_619.setForeground(Color.LIGHT_GRAY);
		textField_619.addMouseListener(this);
		textField_619.setText("9");
		textField_619.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_619.setColumns(10);
		textField_619.setBounds(330, 357, 20, 20);
		add(textField_619);
		
		textField_627 = new JTextField();
		textField_627.setForeground(Color.LIGHT_GRAY);
		textField_627.addMouseListener(this);
		textField_627.setText("7");
		textField_627.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_627.setColumns(10);
		textField_627.setBounds(346, 357, 20, 20);
		add(textField_627);
		
		textField_628 = new JTextField();
		textField_628.setForeground(Color.LIGHT_GRAY);
		textField_628.addMouseListener(this);
		textField_628.setText("8");
		textField_628.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_628.setColumns(10);
		textField_628.setBounds(359, 357, 20, 20);
		add(textField_628);
		
		textField_629 = new JTextField();
		textField_629.setForeground(Color.LIGHT_GRAY);
		textField_629.addMouseListener(this);
		textField_629.setText("9");
		textField_629.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_629.setColumns(10);
		textField_629.setBounds(372, 357, 20, 20);
		add(textField_629);
		
		textField_637 = new JTextField();
		textField_637.setForeground(Color.LIGHT_GRAY);
		textField_637.addMouseListener(this);
		textField_637.setText("7");
		textField_637.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_637.setColumns(10);
		textField_637.setBounds(388, 357, 20, 20);
		add(textField_637);
		
		textField_639 = new JTextField();
		textField_639.setForeground(Color.LIGHT_GRAY);
		textField_639.addMouseListener(this);
		textField_639.setText("9");
		textField_639.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_639.setColumns(10);
		textField_639.setBounds(414, 357, 20, 20);
		add(textField_639);
		
		textField_638 = new JTextField();
		textField_638.setForeground(Color.LIGHT_GRAY);
		textField_638.addMouseListener(this);
		textField_638.setText("8");
		textField_638.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_638.setColumns(10);
		textField_638.setBounds(401, 357, 20, 20);
		add(textField_638);
		
		textField_701 = new JTextField();
		textField_701.setForeground(Color.LIGHT_GRAY);
		textField_701.addMouseListener(this);
		textField_701.setText("1");
		textField_701.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_701.setColumns(10);
		textField_701.setBounds(304, 375, 20, 20);
		add(textField_701);
		
		textField_702 = new JTextField();
		textField_702.setForeground(Color.LIGHT_GRAY);
		textField_702.addMouseListener(this);
		textField_702.setText("2");
		textField_702.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_702.setColumns(10);
		textField_702.setBounds(317, 375, 20, 20);
		add(textField_702);
		
		textField_703 = new JTextField();
		textField_703.setForeground(Color.LIGHT_GRAY);
		textField_703.addMouseListener(this);
		textField_703.setText("3");
		textField_703.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_703.setColumns(10);
		textField_703.setBounds(330, 375, 20, 20);
		add(textField_703);
		
		textField_711 = new JTextField();
		textField_711.setForeground(Color.LIGHT_GRAY);
		textField_711.addMouseListener(this);
		textField_711.setText("1");
		textField_711.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_711.setColumns(10);
		textField_711.setBounds(346, 375, 20, 20);
		add(textField_711);
		
		textField_712 = new JTextField();
		textField_712.setForeground(Color.LIGHT_GRAY);
		textField_712.addMouseListener(this);
		textField_712.setText("2");
		textField_712.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_712.setColumns(10);
		textField_712.setBounds(359, 375, 20, 20);
		add(textField_712);
		
		textField_713 = new JTextField();
		textField_713.setForeground(Color.LIGHT_GRAY);
		textField_713.addMouseListener(this);
		textField_713.setText("3");
		textField_713.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_713.setColumns(10);
		textField_713.setBounds(372, 375, 20, 20);
		add(textField_713);
		
		textField_721 = new JTextField();
		textField_721.setForeground(Color.LIGHT_GRAY);
		textField_721.addMouseListener(this);
		textField_721.setText("1");
		textField_721.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_721.setColumns(10);
		textField_721.setBounds(388, 375, 20, 20);
		add(textField_721);
		
		textField_722 = new JTextField();
		textField_722.setForeground(Color.LIGHT_GRAY);
		textField_722.addMouseListener(this);
		textField_722.setText("2");
		textField_722.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_722.setColumns(10);
		textField_722.setBounds(401, 375, 20, 20);
		add(textField_722);
		
		textField_723 = new JTextField();
		textField_723.setForeground(Color.LIGHT_GRAY);
		textField_723.addMouseListener(this);
		textField_723.setText("3");
		textField_723.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_723.setColumns(10);
		textField_723.setBounds(414, 375, 20, 20);
		add(textField_723);
		
		textField_704 = new JTextField();
		textField_704.setForeground(Color.LIGHT_GRAY);
		textField_704.addMouseListener(this);
		textField_704.setText("4");
		textField_704.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_704.setColumns(10);
		textField_704.setBounds(304, 390, 20, 20);
		add(textField_704);
		
		textField_705 = new JTextField();
		textField_705.setForeground(Color.LIGHT_GRAY);
		textField_705.addMouseListener(this);
		textField_705.setText("5");
		textField_705.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_705.setColumns(10);
		textField_705.setBounds(317, 390, 20, 20);
		add(textField_705);
		
		textField_706 = new JTextField();
		textField_706.setForeground(Color.LIGHT_GRAY);
		textField_706.addMouseListener(this);
		textField_706.setText("6");
		textField_706.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_706.setColumns(10);
		textField_706.setBounds(330, 390, 20, 20);
		add(textField_706);
		
		textField_714 = new JTextField();
		textField_714.setForeground(Color.LIGHT_GRAY);
		textField_714.addMouseListener(this);
		textField_714.setText("4");
		textField_714.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_714.setColumns(10);
		textField_714.setBounds(346, 390, 20, 20);
		add(textField_714);
		
		textField_715 = new JTextField();
		textField_715.setForeground(Color.LIGHT_GRAY);
		textField_715.addMouseListener(this);
		textField_715.setText("5");
		textField_715.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_715.setColumns(10);
		textField_715.setBounds(359, 390, 20, 20);
		add(textField_715);
		
		textField_716 = new JTextField();
		textField_716.setForeground(Color.LIGHT_GRAY);
		textField_716.addMouseListener(this);
		textField_716.setText("6");
		textField_716.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_716.setColumns(10);
		textField_716.setBounds(372, 390, 20, 20);
		add(textField_716);
		
		textField_724 = new JTextField();
		textField_724.setForeground(Color.LIGHT_GRAY);
		textField_724.addMouseListener(this);
		textField_724.setText("4");
		textField_724.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_724.setColumns(10);
		textField_724.setBounds(388, 390, 20, 20);
		add(textField_724);
		
		textField_725 = new JTextField();
		textField_725.setForeground(Color.LIGHT_GRAY);
		textField_725.addMouseListener(this);
		textField_725.setText("5");
		textField_725.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_725.setColumns(10);
		textField_725.setBounds(401, 390, 20, 20);
		add(textField_725);
		
		textField_726 = new JTextField();
		textField_726.setForeground(Color.LIGHT_GRAY);
		textField_726.addMouseListener(this);
		textField_726.setText("6");
		textField_726.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_726.setColumns(10);
		textField_726.setBounds(414, 390, 20, 20);
		add(textField_726);
		
		textField_707 = new JTextField();
		textField_707.setForeground(Color.LIGHT_GRAY);
		textField_707.addMouseListener(this);
		textField_707.setText("7");
		textField_707.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_707.setColumns(10);
		textField_707.setBounds(304, 405, 20, 20);
		add(textField_707);
		
		textField_708 = new JTextField();
		textField_708.setForeground(Color.LIGHT_GRAY);
		textField_708.addMouseListener(this);
		textField_708.setText("8");
		textField_708.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_708.setColumns(10);
		textField_708.setBounds(317, 405, 20, 20);
		add(textField_708);
		
		textField_709 = new JTextField();
		textField_709.setForeground(Color.LIGHT_GRAY);
		textField_709.addMouseListener(this);
		textField_709.setText("9");
		textField_709.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_709.setColumns(10);
		textField_709.setBounds(330, 405, 20, 20);
		add(textField_709);
		
		textField_717 = new JTextField();
		textField_717.setForeground(Color.LIGHT_GRAY);
		textField_717.addMouseListener(this);
		textField_717.setText("7");
		textField_717.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_717.setColumns(10);
		textField_717.setBounds(346, 405, 20, 20);
		add(textField_717);
		
		textField_718 = new JTextField();
		textField_718.setForeground(Color.LIGHT_GRAY);
		textField_718.addMouseListener(this);
		textField_718.setText("8");
		textField_718.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_718.setColumns(10);
		textField_718.setBounds(359, 405, 20, 20);
		add(textField_718);
		
		textField_719 = new JTextField();
		textField_719.setForeground(Color.LIGHT_GRAY);
		textField_719.addMouseListener(this);
		textField_719.setText("9");
		textField_719.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_719.setColumns(10);
		textField_719.setBounds(372, 405, 20, 20);
		add(textField_719);
		
		textField_727 = new JTextField();
		textField_727.setForeground(Color.LIGHT_GRAY);
		textField_727.addMouseListener(this);
		textField_727.setText("7");
		textField_727.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_727.setColumns(10);
		textField_727.setBounds(388, 405, 20, 20);
		add(textField_727);
		
		textField_728 = new JTextField();
		textField_728.setForeground(Color.LIGHT_GRAY);
		textField_728.addMouseListener(this);
		textField_728.setText("8");
		textField_728.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_728.setColumns(10);
		textField_728.setBounds(401, 405, 20, 20);
		add(textField_728);
		
		textField_729 = new JTextField();
		textField_729.setForeground(Color.LIGHT_GRAY);
		textField_729.addMouseListener(this);
		textField_729.setText("9");
		textField_729.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_729.setColumns(10);
		textField_729.setBounds(414, 405, 20, 20);
		add(textField_729);
		
		textField_791 = new JTextField();
		textField_791.setForeground(Color.LIGHT_GRAY);
		textField_791.addMouseListener(this);
		textField_791.setText("1");
		textField_791.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_791.setColumns(10);
		textField_791.setBounds(304, 423, 20, 20);
		add(textField_791);
		
		textField_792 = new JTextField();
		textField_792.setForeground(Color.LIGHT_GRAY);
		textField_792.addMouseListener(this);
		textField_792.setText("2");
		textField_792.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_792.setColumns(10);
		textField_792.setBounds(317, 423, 20, 20);
		add(textField_792);
		
		textField_793 = new JTextField();
		textField_793.setForeground(Color.LIGHT_GRAY);
		textField_793.addMouseListener(this);
		textField_793.setText("3");
		textField_793.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_793.setColumns(10);
		textField_793.setBounds(330, 423, 20, 20);
		add(textField_793);
		
		textField_801 = new JTextField();
		textField_801.setForeground(Color.LIGHT_GRAY);
		textField_801.addMouseListener(this);
		textField_801.setText("1");
		textField_801.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_801.setColumns(10);
		textField_801.setBounds(346, 423, 20, 20);
		add(textField_801);
		
		textField_802 = new JTextField();
		textField_802.setForeground(Color.LIGHT_GRAY);
		textField_802.addMouseListener(this);
		textField_802.setText("2");
		textField_802.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_802.setColumns(10);
		textField_802.setBounds(359, 423, 20, 20);
		add(textField_802);
		
		textField_803 = new JTextField();
		textField_803.setForeground(Color.LIGHT_GRAY);
		textField_803.addMouseListener(this);
		textField_803.setText("3");
		textField_803.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_803.setColumns(10);
		textField_803.setBounds(372, 423, 20, 20);
		add(textField_803);
		
		textField_811 = new JTextField();
		textField_811.setForeground(Color.LIGHT_GRAY);
		textField_811.addMouseListener(this);
		textField_811.setText("1");
		textField_811.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_811.setColumns(10);
		textField_811.setBounds(388, 423, 20, 20);
		add(textField_811);
		
		textField_812 = new JTextField();
		textField_812.setForeground(Color.LIGHT_GRAY);
		textField_812.addMouseListener(this);
		textField_812.setText("2");
		textField_812.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_812.setColumns(10);
		textField_812.setBounds(401, 423, 20, 20);
		add(textField_812);
		
		textField_813 = new JTextField();
		textField_813.setForeground(Color.LIGHT_GRAY);
		textField_813.addMouseListener(this);
		textField_813.setText("3");
		textField_813.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_813.setColumns(10);
		textField_813.setBounds(414, 423, 20, 20);
		add(textField_813);
		
		textField_794 = new JTextField();
		textField_794.setForeground(Color.LIGHT_GRAY);
		textField_794.addMouseListener(this);
		textField_794.setText("4");
		textField_794.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_794.setColumns(10);
		textField_794.setBounds(304, 438, 20, 20);
		add(textField_794);
		
		textField_795 = new JTextField();
		textField_795.setForeground(Color.LIGHT_GRAY);
		textField_795.addMouseListener(this);
		textField_795.setText("5");
		textField_795.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_795.setColumns(10);
		textField_795.setBounds(317, 438, 20, 20);
		add(textField_795);
		
		textField_796 = new JTextField();
		textField_796.setForeground(Color.LIGHT_GRAY);
		textField_796.addMouseListener(this);
		textField_796.setText("6");
		textField_796.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_796.setColumns(10);
		textField_796.setBounds(330, 438, 20, 20);
		add(textField_796);
		
		textField_804 = new JTextField();
		textField_804.setForeground(Color.LIGHT_GRAY);
		textField_804.addMouseListener(this);
		textField_804.setText("4");
		textField_804.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_804.setColumns(10);
		textField_804.setBounds(346, 438, 20, 20);
		add(textField_804);
		
		textField_805 = new JTextField();
		textField_805.setForeground(Color.LIGHT_GRAY);
		textField_805.addMouseListener(this);
		textField_805.setText("5");
		textField_805.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_805.setColumns(10);
		textField_805.setBounds(359, 438, 20, 20);
		add(textField_805);
		
		textField_806 = new JTextField();
		textField_806.setForeground(Color.LIGHT_GRAY);
		textField_806.addMouseListener(this);
		textField_806.setText("6");
		textField_806.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_806.setColumns(10);
		textField_806.setBounds(372, 438, 20, 20);
		add(textField_806);
		
		textField_814 = new JTextField();
		textField_814.setForeground(Color.LIGHT_GRAY);
		textField_814.addMouseListener(this);
		textField_814.setText("4");
		textField_814.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_814.setColumns(10);
		textField_814.setBounds(388, 438, 20, 20);
		add(textField_814);
		
		textField_815 = new JTextField();
		textField_815.setForeground(Color.LIGHT_GRAY);
		textField_815.addMouseListener(this);
		textField_815.setText("5");
		textField_815.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_815.setColumns(10);
		textField_815.setBounds(401, 438, 20, 20);
		add(textField_815);
		
		textField_816 = new JTextField();
		textField_816.setForeground(Color.LIGHT_GRAY);
		textField_816.addMouseListener(this);
		textField_816.setText("6");
		textField_816.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_816.setColumns(10);
		textField_816.setBounds(414, 438, 20, 20);
		add(textField_816);
		
		textField_797 = new JTextField();
		textField_797.setForeground(Color.LIGHT_GRAY);
		textField_797.addMouseListener(this);
		textField_797.setText("7");
		textField_797.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_797.setColumns(10);
		textField_797.setBounds(304, 453, 20, 20);
		add(textField_797);
		
		textField_798 = new JTextField();
		textField_798.setForeground(Color.LIGHT_GRAY);
		textField_798.addMouseListener(this);
		textField_798.setText("8");
		textField_798.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_798.setColumns(10);
		textField_798.setBounds(317, 453, 20, 20);
		add(textField_798);
		
		textField_799 = new JTextField();
		textField_799.setForeground(Color.LIGHT_GRAY);
		textField_799.addMouseListener(this);
		textField_799.setText("9");
		textField_799.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_799.setColumns(10);
		textField_799.setBounds(330, 453, 20, 20);
		add(textField_799);
		
		textField_807 = new JTextField();
		textField_807.setForeground(Color.LIGHT_GRAY);
		textField_807.addMouseListener(this);
		textField_807.setText("7");
		textField_807.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_807.setColumns(10);
		textField_807.setBounds(346, 453, 20, 20);
		add(textField_807);
		
		textField_808 = new JTextField();
		textField_808.setForeground(Color.LIGHT_GRAY);
		textField_808.addMouseListener(this);
		textField_808.setText("8");
		textField_808.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_808.setColumns(10);
		textField_808.setBounds(359, 453, 20, 20);
		add(textField_808);
		
		textField_809 = new JTextField();
		textField_809.setForeground(Color.LIGHT_GRAY);
		textField_809.addMouseListener(this);
		textField_809.setText("9");
		textField_809.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_809.setColumns(10);
		textField_809.setBounds(372, 453, 20, 20);
		add(textField_809);
		
		textField_817 = new JTextField();
		textField_817.setForeground(Color.LIGHT_GRAY);
		textField_817.addMouseListener(this);
		textField_817.setText("7");
		textField_817.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_817.setColumns(10);
		textField_817.setBounds(388, 453, 20, 20);
		add(textField_817);
		
		textField_818 = new JTextField();
		textField_818.setForeground(Color.LIGHT_GRAY);
		textField_818.addMouseListener(this);
		textField_818.setText("8");
		textField_818.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_818.setColumns(10);
		textField_818.setBounds(401, 453, 20, 20);
		add(textField_818);
		
		textField_819 = new JTextField();
		textField_819.setForeground(Color.LIGHT_GRAY);
		textField_819.addMouseListener(this);
		textField_819.setHorizontalAlignment(SwingConstants.CENTER);
		textField_819.setText("9");
		textField_819.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		textField_819.setColumns(10);
		textField_819.setBounds(414, 453, 20, 20);
		add(textField_819);
		
		
		textField = new JTextField();
		textField.setBounds(590, 31, 272, 264);
		add(textField);
		textField.setColumns(10);
	}
	
	public void mouseClicked(MouseEvent ev) {
		JTextField JT = (JTextField) ev.getSource();
        if ( SwingUtilities.isLeftMouseButton(ev) ) {
        	changementTaille(JT);
        
        } else if(SwingUtilities.isRightMouseButton(ev)) {
        	changementCouleur(JT);
        } 
} 
	public void mousePressed(MouseEvent ev){}
	public void mouseReleased (MouseEvent ev){}
	public void mouseEntered (MouseEvent ev){}
	public void mouseExited (MouseEvent ev){}
	
	public void changementCouleur(JTextField JT){
		if(JT.getForeground()==Color.LIGHT_GRAY){
			JT.setForeground(Color.BLACK);
		}else{
			JT.setForeground(Color.LIGHT_GRAY);
		}
	}
	
	public void changementTaille(JTextField JT){
		int x;
		int y;
		int h;
		int w;
		String te;
		x = JT.getX();
		y = JT.getY();
		h = JT.getHeight();
		w = JT.getWidth();
		te=JT.getText();		
		int i = Integer.parseInt(te);
		if(i==1){
			JT.setBounds(x, y, w+41, h+41);
		}
		if(i==2){
				JT.setBounds(x-13, y, w+41, h+41);
			}
		if(i==3){
			JT.setBounds(x-26, y, w+41, h+41);
		}
		if(i==4){
			JT.setBounds(x, y-13, w+41, h+41);
		}
		if(i==5){
			JT.setBounds(x-13, y-14, w+41, h+41);
		}
		if(i==6){
			JT.setBounds(x-26, y-13, w+41, h+41);
		}
		if(i==7){
			JT.setBounds(x, y-26, w+41, h+41);
		}
		if(i==8){
			JT.setBounds(x-13, y-26, w+41, h+41);
		}
		if(i==9){
			JT.setBounds(x-26, y-26, w+41, h+41);
		}
	}
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grille frame = new Grille();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
