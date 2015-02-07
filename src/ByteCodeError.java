
public class ByteCodeError {
	// 1
	// Byte code:
    //   0: ldc 158
    //   2: iload_1
    //   3: aload_0
    //   4: dup
    //   5: astore_3
    //   6: getfield 513	aeii/Class_g_1956:var_4872	[[B
    //   9: aload_3
    //   10: getfield 451	aeii/Class_g_1956:var_4842	B
    //   13: aaload
    //   14: iconst_0
    //   15: aload_3
    //   16: getfield 564	aeii/Class_g_1956:var_4772	I
    //   19: i2b
    //   20: bastore
    //   21: aload_3
    //   22: getfield 513	aeii/Class_g_1956:var_4872	[[B
    //   25: aload_3
    //   26: getfield 451	aeii/Class_g_1956:var_4842	B
    //   29: aaload
    //   30: iconst_1
    //   31: aload_3
    //   32: getfield 575	aeii/Class_g_1956:var_477a	I
    //   35: i2b
    //   36: bastore
    //   37: new 199	java/io/ByteArrayOutputStream
    //   40: dup
    //   41: invokespecial 945	java/io/ByteArrayOutputStream:<init>	()V
    //   44: astore 4
    //   46: new 201	java/io/DataOutputStream
    //   49: dup
    //   50: aload 4
    //   52: invokespecial 960	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: dup
    //   56: astore 5
    //   58: aload_3
    //   59: getfield 475	aeii/Class_g_1956:var_45fa	B
    //   62: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   65: aload 5
    //   67: aload_3
    //   68: getfield 682	aeii/Class_g_1956:var_47a2	I
    //   71: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   74: aload 5
    //   76: aload_3
    //   77: getfield 532	aeii/Class_g_1956:var_4822	B
    //   80: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   83: aload 5
    //   85: aload_3
    //   86: getfield 451	aeii/Class_g_1956:var_4842	B
    //   89: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   92: aload 5
    //   94: aload_3
    //   95: getfield 508	aeii/Class_g_1956:var_4832	[B
    //   98: aload_3
    //   99: getfield 451	aeii/Class_g_1956:var_4842	B
    //   102: baload
    //   103: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   106: aload 5
    //   108: aload_3
    //   109: getfield 402	aeii/Class_g_1956:var_484a	S
    //   112: invokevirtual 965	java/io/DataOutputStream:writeShort	(I)V
    //   115: aload 5
    //   117: aload_3
    //   118: getfield 622	aeii/Class_g_1956:var_49ca	I
    //   121: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   124: aload 5
    //   126: aload_3
    //   127: getfield 532	aeii/Class_g_1956:var_4822	B
    //   130: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   133: iconst_0
    //   134: istore 6
    //   136: iload 6
    //   138: aload_3
    //   139: getfield 532	aeii/Class_g_1956:var_4822	B
    //   142: if_icmpge +73 -> 215
    //   145: aload 5
    //   147: aload_3
    //   148: getfield 527	aeii/Class_g_1956:var_483a	[B
    //   151: iload 6
    //   153: baload
    //   154: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   157: aload 5
    //   159: aload_3
    //   160: getfield 609	aeii/Class_g_1956:var_487a	[B
    //   163: iload 6
    //   165: baload
    //   166: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   169: aload 5
    //   171: aload_3
    //   172: getfield 467	aeii/Class_g_1956:var_486a	[I
    //   175: iload 6
    //   177: iaload
    //   178: invokevirtual 964	java/io/DataOutputStream:writeInt	(I)V
    //   181: aload 5
    //   183: aload_3
    //   184: getfield 513	aeii/Class_g_1956:var_4872	[[B
    //   187: iload 6
    //   189: aaload
    //   190: iconst_0
    //   191: baload
    //   192: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   195: aload 5
    //   197: aload_3
    //   198: getfield 513	aeii/Class_g_1956:var_4872	[[B
    //   201: iload 6
    //   203: aaload
    //   204: iconst_1
    //   205: baload
    //   206: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   209: iinc 6 1
    //   212: goto -76 -> 136
    //   215: aload 5
    //   217: aload_3
    //   218: getfield 659	aeii/Class_g_1956:var_45f2	I
    //   221: invokevirtual 965	java/io/DataOutputStream:writeShort	(I)V
    //   224: iconst_0
    //   225: istore 6
    //   227: iload 6
    //   229: aload_3
    //   230: getfield 531	aeii/Class_g_1956:var_49fa	[[B
    //   233: arraylength
    //   234: if_icmpge +38 -> 272
    //   237: aload 5
    //   239: aload_3
    //   240: getfield 412	aeii/Class_g_1956:var_4782	[[B
    //   243: aload_3
    //   244: getfield 531	aeii/Class_g_1956:var_49fa	[[B
    //   247: iload 6
    //   249: aaload
    //   250: iconst_0
    //   251: baload
    //   252: aaload
    //   253: aload_3
    //   254: getfield 531	aeii/Class_g_1956:var_49fa	[[B
    //   257: iload 6
    //   259: aaload
    //   260: iconst_1
    //   261: baload
    //   262: baload
    //   263: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   266: iinc 6 1
    //   269: goto -42 -> 227
    //   272: aload 5
    //   274: aload_3
    //   275: getfield 394	aeii/Class_g_1956:var_47fa	Ljava/util/Vector;
    //   278: invokevirtual 1014	java/util/Vector:size	()I
    //   281: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   284: iconst_0
    //   285: istore 6
    //   287: aload_3
    //   288: getfield 394	aeii/Class_g_1956:var_47fa	Ljava/util/Vector;
    //   291: invokevirtual 1014	java/util/Vector:size	()I
    //   294: istore 7
    //   296: iload 6
    //   298: iload 7
    //   300: if_icmpge +188 -> 488
    //   303: aload_3
    //   304: getfield 394	aeii/Class_g_1956:var_47fa	Ljava/util/Vector;
    //   307: iload 6
    //   309: invokevirtual 1010	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   312: checkcast 190	aeii/Class_a_0260
    //   315: astore 8
    //   317: aload 5
    //   319: aload 8
    //   321: getfield 277	aeii/Class_a_0260:var_e2b	B
    //   324: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   327: aload 5
    //   329: aload 8
    //   331: getfield 279	aeii/Class_a_0260:var_e33	B
    //   334: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   337: aload 5
    //   339: aload 8
    //   341: getfield 281	aeii/Class_a_0260:var_e83	B
    //   344: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   347: aload 5
    //   349: aload 8
    //   351: getfield 283	aeii/Class_a_0260:var_e8b	B
    //   354: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   357: aload 5
    //   359: aload 8
    //   361: getfield 286	aeii/Class_a_0260:var_e7b	I
    //   364: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   367: aload 5
    //   369: aload 8
    //   371: getfield 267	aeii/Class_a_0260:var_dfb	S
    //   374: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   377: aload 5
    //   379: aload 8
    //   381: getfield 264	aeii/Class_a_0260:var_e03	I
    //   384: invokevirtual 965	java/io/DataOutputStream:writeShort	(I)V
    //   387: aload 5
    //   389: aload 8
    //   391: getfield 273	aeii/Class_a_0260:var_e3b	S
    //   394: invokevirtual 965	java/io/DataOutputStream:writeShort	(I)V
    //   397: aload 5
    //   399: aload 8
    //   401: getfield 276	aeii/Class_a_0260:var_e43	S
    //   404: invokevirtual 965	java/io/DataOutputStream:writeShort	(I)V
    //   407: aload 5
    //   409: aload 8
    //   411: getfield 285	aeii/Class_a_0260:var_ecb	B
    //   414: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   417: aload 5
    //   419: aload 8
    //   421: getfield 287	aeii/Class_a_0260:var_ed3	B
    //   424: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   427: aload 8
    //   429: getfield 277	aeii/Class_a_0260:var_e2b	B
    //   432: bipush 9
    //   434: if_icmpne +48 -> 482
    //   437: aload 5
    //   439: aload 8
    //   441: getfield 289	aeii/Class_a_0260:var_eeb	B
    //   444: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   447: aload 5
    //   449: aload 8
    //   451: getfield 290	aeii/Class_a_0260:var_efb	I
    //   454: invokevirtual 965	java/io/DataOutputStream:writeShort	(I)V
    //   457: aload 5
    //   459: aload_3
    //   460: getfield 469	aeii/Class_g_1956:var_4852	[Laeii/Class_a_0260;
    //   463: aload 8
    //   465: getfield 279	aeii/Class_a_0260:var_e33	B
    //   468: aaload
    //   469: aload 8
    //   471: if_acmpne +7 -> 478
    //   474: iconst_1
    //   475: goto +4 -> 479
    //   478: iconst_0
    //   479: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   482: iinc 6 1
    //   485: goto -189 -> 296
    //   488: aload 5
    //   490: aload_3
    //   491: getfield 449	aeii/Class_g_1956:var_4e12	I
    //   494: i2s
    //   495: invokevirtual 965	java/io/DataOutputStream:writeShort	(I)V
    //   498: aload 5
    //   500: aload_3
    //   501: getfield 595	aeii/Class_g_1956:var_4e22	J
    //   504: l2i
    //   505: i2s
    //   506: invokevirtual 964	java/io/DataOutputStream:writeInt	(I)V
    //   509: aload 5
    //   511: aload_3
    //   512: getfield 450	aeii/Class_g_1956:var_4e2a	I
    //   515: invokevirtual 964	java/io/DataOutputStream:writeInt	(I)V
    //   518: aload 5
    //   520: aload_3
    //   521: getfield 690	aeii/Class_g_1956:var_4e32	Z
    //   524: ifeq +7 -> 531
    //   527: iconst_0
    //   528: goto +4 -> 532
    //   531: iconst_1
    //   532: invokevirtual 963	java/io/DataOutputStream:writeByte	(I)V
    //   535: aload 4
    //   537: invokevirtual 948	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   540: astore 7
    //   542: aload 5
    //   544: invokevirtual 961	java/io/DataOutputStream:close	()V
    //   547: aload 7
    //   549: invokestatic 769	aeii/Class_c_0282:sub_1ccb	(Ljava/lang/String;I[B)V
    //   552: aload_0
    //   553: getfield 602	aeii/Class_g_1956:var_4b5a	[Ljava/lang/String;
    //   556: iload_1
    //   557: aload_0
    //   558: aload_0
    //   559: getfield 475	aeii/Class_g_1956:var_45fa	B
    //   562: aload_0
    //   563: getfield 682	aeii/Class_g_1956:var_47a2	I
    //   566: aload_0
    //   567: getfield 402	aeii/Class_g_1956:var_484a	S
    //   570: invokespecial 845	aeii/Class_g_1956:sub_5d02	(III)Ljava/lang/String;
    //   573: aastore
    //   574: aload_0
    //   575: getfield 618	aeii/Class_g_1956:var_4b62	[B
    //   578: iload_1
    //   579: aload_0
    //   580: getfield 508	aeii/Class_g_1956:var_4832	[B
    //   583: aload_0
    //   584: getfield 451	aeii/Class_g_1956:var_4842	B
    //   587: baload
    //   588: bastore
    //   589: aload_0
    //   590: getfield 601	aeii/Class_g_1956:var_4b6a	[I
    //   593: iload_1
    //   594: aload_0
    //   595: getfield 682	aeii/Class_g_1956:var_47a2	I
    //   598: iastore
    //   599: aload_0
    //   600: getfield 672	aeii/Class_g_1956:var_4b8a	Laeii/Class_e_0134;
    //   603: aconst_null
    //   604: aload_0
    //   605: getfield 602	aeii/Class_g_1956:var_4b5a	[Ljava/lang/String;
    //   608: iload_1
    //   609: aaload
    //   610: aload_0
    //   611: getfield 382	aeii/Class_g_1956:var_459a	I
    //   614: iconst_m1
    //   615: invokevirtual 807	aeii/Class_e_0134:sub_1ca8	(Ljava/lang/String;Ljava/lang/String;II)V
    //   618: aload_0
    //   619: getfield 672	aeii/Class_g_1956:var_4b8a	Laeii/Class_e_0134;
    //   622: getstatic 546	aeii/Class_g_1956:var_468a	[I
    //   625: aload_0
    //   626: getfield 618	aeii/Class_g_1956:var_4b62	[B
    //   629: iload_1
    //   630: baload
    //   631: iaload
    //   632: putfield 325	aeii/Class_e_0134:var_11a2	I
    //   635: aload_0
    //   636: getfield 672	aeii/Class_g_1956:var_4b8a	Laeii/Class_e_0134;
    //   639: invokevirtual 799	aeii/Class_e_0134:sub_1272	()V
    //   642: aload_0
    //   643: aconst_null
    //   644: bipush 77
    //   646: invokestatic 816	aeii/Class_f_0145:sub_c07	(I)Ljava/lang/String;
    //   649: aload_0
    //   650: getfield 452	aeii/Class_g_1956:var_45a2	I
    //   653: sipush 1000
    //   656: invokespecial 868	aeii/Class_g_1956:sub_14359	(Ljava/lang/String;Ljava/lang/String;II)Laeii/Class_e_0134;
    //   659: dup
    //   660: astore_1
    //   661: aload_2
    //   662: putfield 313	aeii/Class_e_0134:var_111a	Laeii/Class_f_0145;
    //   665: getstatic 328	aeii/Class_f_0145:var_743	Laeii/Class_c_0282;
    //   668: aload_1
    //   669: invokevirtual 762	aeii/Class_c_0282:sub_220e	(Laeii/Class_f_0145;)V
    //   672: return
    //   673: pop
    //   674: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	Class_g_1956
    //   0	675	1	paramInt	int
    //   0	675	2	paramClass_f_0145	Class_f_0145
    //   5	516	3	localClass_g_1956	Class_g_1956
    //   44	492	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   56	487	5	localDataOutputStream	DataOutputStream
    //   134	349	6	i	int
    //   294	7	7	j	int
    //   540	8	7	arrayOfByte	byte[]
    //   315	155	8	localClass_a_0260	Class_a_0260
    // Exception table:
    //   from	to	target	type
    //   0	672	673	java/lang/Exception
	
	
	
	
	
	
	// 2
	
	// Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 391	aeii/Class_g_1956:var_4f1a	Ljava/io/ByteArrayOutputStream;
    //   8: invokevirtual 948	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 391	aeii/Class_g_1956:var_4f1a	Ljava/io/ByteArrayOutputStream;
    //   16: invokevirtual 946	java/io/ByteArrayOutputStream:close	()V
    //   19: aload_0
    //   20: getfield 392	aeii/Class_g_1956:var_4f22	Ljava/io/DataOutputStream;
    //   23: invokevirtual 961	java/io/DataOutputStream:close	()V
    //   26: aload_0
    //   27: getfield 539	aeii/Class_g_1956:var_4f12	Ljava/lang/String;
    //   30: invokestatic 1015	javax/microedition/io/Connector:open	(Ljava/lang/String;)Ljavax/microedition/io/Connection;
    //   33: checkcast 217	javax/microedition/io/HttpConnection
    //   36: astore_2
    //   37: ldc 64
    //   39: invokevirtual 987	java/lang/String:length	()I
    //   42: ifle +46 -> 88
    //   45: ldc 64
    //   47: invokevirtual 984	java/lang/String:getBytes	()[B
    //   50: astore 4
    //   52: aload_0
    //   53: getfield 423	aeii/Class_g_1956:var_4f2a	I
    //   56: istore 5
    //   58: iload 5
    //   60: aload_3
    //   61: arraylength
    //   62: if_icmpge +26 -> 88
    //   65: aload_3
    //   66: iload 5
    //   68: dup2
    //   69: baload
    //   70: aload 4
    //   72: iload 5
    //   74: aload 4
    //   76: arraylength
    //   77: irem
    //   78: baload
    //   79: ixor
    //   80: i2b
    //   81: bastore
    //   82: iinc 5 1
    //   85: goto -27 -> 58
    //   88: aload_2
    //   89: ldc 70
    //   91: invokeinterface 1066 2 0
    //   96: aload_2
    //   97: ldc 54
    //   99: aload_3
    //   100: arraylength
    //   101: invokestatic 976	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   104: invokeinterface 1067 3 0
    //   109: aload_2
    //   110: ldc 53
    //   112: ldc 114
    //   114: invokeinterface 1067 3 0
    //   119: aload_2
    //   120: invokeinterface 1065 1 0
    //   125: dup
    //   126: astore 4
    //   128: aload_3
    //   129: invokevirtual 972	java/io/OutputStream:write	([B)V
    //   132: aload 4
    //   134: invokevirtual 971	java/io/OutputStream:flush	()V
    //   137: aload 4
    //   139: invokevirtual 970	java/io/OutputStream:close	()V
    //   142: aload_2
    //   143: invokeinterface 1064 1 0
    //   148: astore 5
    //   150: aload_2
    //   151: invokeinterface 1063 1 0
    //   156: dup
    //   157: istore_3
    //   158: sipush 200
    //   161: if_icmpeq +30 -> 191
    //   164: new 205	java/lang/Exception
    //   167: dup
    //   168: new 211	java/lang/StringBuffer
    //   171: dup
    //   172: invokespecial 993	java/lang/StringBuffer:<init>	()V
    //   175: ldc 23
    //   177: invokevirtual 997	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   180: iload_3
    //   181: invokevirtual 996	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   184: invokevirtual 998	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   187: invokespecial 973	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: new 199	java/io/ByteArrayOutputStream
    //   194: dup
    //   195: invokespecial 945	java/io/ByteArrayOutputStream:<init>	()V
    //   198: astore_3
    //   199: aload 5
    //   201: invokevirtual 952	java/io/DataInputStream:read	()I
    //   204: dup
    //   205: istore 4
    //   207: iconst_m1
    //   208: if_icmpeq +12 -> 220
    //   211: aload_3
    //   212: iload 4
    //   214: invokevirtual 949	java/io/ByteArrayOutputStream:write	(I)V
    //   217: goto -18 -> 199
    //   220: aload_3
    //   221: invokevirtual 948	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   224: astore_1
    //   225: aload_3
    //   226: invokevirtual 946	java/io/ByteArrayOutputStream:close	()V
    //   229: aload 5
    //   231: invokevirtual 951	java/io/DataInputStream:close	()V
    //   234: aload_2
    //   235: ifnull +67 -> 302
    //   238: aload_2
    //   239: invokeinterface 1062 1 0
    //   244: goto +58 -> 302
    //   247: dup
    //   248: astore_3
    //   249: invokevirtual 974	java/lang/Exception:printStackTrace	()V
    //   252: goto +50 -> 302
    //   255: dup
    //   256: astore_3
    //   257: invokevirtual 974	java/lang/Exception:printStackTrace	()V
    //   260: aload_2
    //   261: ifnull +41 -> 302
    //   264: aload_2
    //   265: invokeinterface 1062 1 0
    //   270: goto +32 -> 302
    //   273: dup
    //   274: astore_3
    //   275: invokevirtual 974	java/lang/Exception:printStackTrace	()V
    //   278: goto +24 -> 302
    //   281: astore_1
    //   282: aload_2
    //   283: ifnull +17 -> 300
    //   286: aload_2
    //   287: invokeinterface 1062 1 0
    //   292: goto +8 -> 300
    //   295: dup
    //   296: astore_2
    //   297: invokevirtual 974	java/lang/Exception:printStackTrace	()V
    //   300: aload_1
    //   301: athrow
    //   302: aload_0
    //   303: getfield 353	aeii/Class_g_1956:var_4f32	Z
    //   306: ifne +8 -> 314
    //   309: aload_0
    //   310: aload_1
    //   311: invokespecial 903	aeii/Class_g_1956:sub_189c7	([B)V
    //   314: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	Class_g_1956
    //   1	224	1	arrayOfByte1	byte[]
    //   281	30	1	arrayOfByte2	byte[]
    //   3	294	2	localObject1	Object
    //   11	118	3	arrayOfByte3	byte[]
    //   157	24	3	i	int
    //   198	77	3	localObject2	Object
    //   50	88	4	localObject3	Object
    //   205	8	4	j	int
    //   56	27	5	k	int
    //   148	82	5	localDataInputStream	DataInputStream
    //   247	1	11	localException1	Exception
    //   255	1	12	localException2	Exception
    //   273	1	13	localException3	Exception
    //   295	1	14	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   238	244	247	java/lang/Exception
    //   4	234	255	java/lang/Exception
    //   264	270	273	java/lang/Exception
    //   4	234	281	finally
    //   255	260	281	finally
    //   286	292	295	java/lang/Exception
}
