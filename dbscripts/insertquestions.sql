INSERT INTO public.questions(
	id, communication_mode, downvote_count, preferred_language, preferred_time, question_text, title, upvote_count, owner_user_id)
	VALUES (22950041, null, 1, 'english', null, '<p>I was looking at the definition of existential types on Wikipedia (<a href="http://en.wikipedia.org/wiki/Type_system#Existential_types" rel="nofollow">Existential_types</a>) and it feels similar in some way to concepts in C++ (particularly to <a href="http://www.open-std.org/jtc1/sc22/wg21/docs/papers/2012/n3351.pdf" rel="nofollow">concepts lite</a>).</p><p>Are C++ concepts a form of existential type?</p><p>If not, what are the differences between the two?</p>', null, 10,1);

INSERT INTO public.questions_tags(
	question_id, tags_id)
	VALUES (22950041, 1);
	
INSERT INTO public.questions(
	id, communication_mode, downvote_count, preferred_language, preferred_time, question_text, title, upvote_count, owner_user_id)
	VALUES (67554, null, 3, 'english', null, '<p>Im looking for a profiler in order to find the bottleneck in my C++ code. Id like to find a free, non-intrusive, and good profiling tool. Im a game developer, and I use PIX for Xbox&nbsp;360 and found it very good, but its not free. I know the Intel <a href="https://en.wikipedia.org/wiki/VTune" rel="noreferrer">VTune</a>, but its not free either.</p>', null, 203,4);

INSERT INTO public.questions_tags(
	question_id, tags_id)
	VALUES (67554, 1);
	
INSERT INTO public.questions(
	id, communication_mode, downvote_count, preferred_language, preferred_time, question_text, title, upvote_count, owner_user_id)
	VALUES (1096615, null, 1, 'english', null, '<p>Has anyone tried automatic Java to C++ conversion for speed improvements? Is it a maintenance nightmare in the long run? Just read that is used to generate the HTML5 parsing engine in Gecko <a href="http://ejohn.org/blog/html-5-parsing/" rel="nofollow noreferrer">http://ejohn.org/blog/html-5-parsing/</a></p>', null, 3,3);

INSERT INTO public.questions_tags(
	question_id, tags_id)
	VALUES (1096615, 1);
	
INSERT INTO public.questions_tags(
	question_id, tags_id)
	VALUES (1096615, 2);
	
INSERT INTO public.questions(
	id, communication_mode, downvote_count, preferred_language, preferred_time, question_text, title, upvote_count, owner_user_id)
	VALUES (9119481, null, 2, 'english', null, '<p>Coming from .NET i am so used calling Alert() in desktop apps. However in this java desktop app, I just want to alert a message saying "thank you for using java" I have to go through this much suffering:</p><p>(using a JOptionPane)</><p>Is there an easier way?</p>', null, 102,4);
	

INSERT INTO public.questions_tags(
	question_id, tags_id)
	VALUES (9119481, 2);

INSERT INTO public.questions(
	id, communication_mode, downvote_count, preferred_language, preferred_time, question_text, title, upvote_count, owner_user_id)
	VALUES (5144424, null, 1, 'english', null, '<p>It seems JSTL is no longer even mentioned in the <a href="http://download.oracle.com/javaee/6/tutorial/doc/bnarf.html" rel="nofollow">Java EE 6 Tutorial</a>, Oracle instead favouring the JSF libraries heavily over the older jstl core libraries. Does this indicate that it is now unmaintained and will be scrapped in future version of the platform?</p> <p>edit: Apparently the <a href="http://download.oracle.com/javaee/6/javaserverfaces/2.1/docs/vdldocs/facelets/" rel="nofollow">documentation</a> for the JSF tags includes documentation for the core tags. Im not sure whether that means they are considered to be of core function any more though, since they arent even any examples in the tutorial.</p>', null, 4,5);
	
INSERT INTO public.questions_tags(
	question_id, tags_id)
	VALUES (5144424, 2);
	
INSERT INTO public.questions(
	id, communication_mode, downvote_count, preferred_language, preferred_time, question_text, title, upvote_count, owner_user_id)
	VALUES (30530663, null, 1, 'english', null, '<p>Im looking for a way to do the equivalent to the sql </p><blockquote> <p>SELECT DISTINCT col1, col2 FROM dataframe_table</p></blockquote><p>The pandas sql comparison doesnt have anything about distinct</p><p>.unique() only works for a single column, so I suppose I could concat the columns, or put them in a list/tuple and compare that way, but this seems like something pandas should do in a more native way.  </p><p>Am I missing something obvious, or is there no way to do this?</p>', null, 33,5);
	
INSERT INTO public.questions_tags(
	question_id, tags_id)
	VALUES (30530663, 3);
	

	
INSERT INTO public.questions(
	id, communication_mode, downvote_count, preferred_language, preferred_time, question_text, title, upvote_count, owner_user_id)
	VALUES (4881377, null, 1, 'english', null, '<p>We want to  parse our huge C++ source tree to gain enough info to feed to another tool to make diagrams of class and object relations, discern the overall organization of things etc.  </p><p>My best try so far is a Python script that scans all .cpp and .h files, runs regex searches to try to detect class declarations, methods, etc.   We dont need a full-blown analyzer to capture every detail, or some heavy UML diagram generator - theres a lot of detail wed like to ignore and were inventing new types of diagrams.  The script sorta works, but by gosh its true: C++ <em>is</em> hard to parse!   </p><p>So I wonder what tools exist for extracting the info we want from our sources? Im not a language expert, and dont want something with a steep learning curve.  Something we low-brow blue-collar programmer grunts can use :P</p><p>Python is preferred as one of the standard languages here, but its not essential.</p>', null, 13,7);
	
INSERT INTO public.questions_tags(
	question_id, tags_id)
	VALUES (4881377, 3);
	

INSERT INTO public.questions_tags(
	question_id, tags_id)
	VALUES (4881377, 1);
