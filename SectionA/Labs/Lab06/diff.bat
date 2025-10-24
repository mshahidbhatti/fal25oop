@echo off
setlocal

REM === CONFIG ===
set "FOLDER=G:\My Drive\Dr. Aksam Tasks\Samina_secondpaper\16-10-2025"
set "OLD=old.tex"
set "NEW=main.tex"
set "OUT=diff_added_only.tex"
set "OUTNAME=diff_added_only"
REM Set to 1 if your doc uses minted or needs shell-escape
set "USE_SHELL_ESCAPE=0"

cd /d "%FOLDER%" || (echo [ERROR] Folder not found: %FOLDER% & exit /b 1)

REM Prefer XeLaTeX for Unicode; fallback to pdfLaTeX
where xelatex >nul 2>&1 && (set "LATEX=xelatex") || (set "LATEX=pdflatex")
echo Using LaTeX engine: %LATEX%

REM Hide deletions; color additions blue
set "PREAMBLE=\usepackage{xcolor}\renewcommand{\DIFdel}[1]{}\renewcommand{\DIFdelbegin}{}\renewcommand{\DIFdelend}{}\renewcommand{\DIFadd}[1]{\textcolor{blue}{#1}}"

REM If pdfLaTeX, add UTF-8 and common Unicode mappings (≈ – — …)
if /I "%LATEX%"=="pdflatex" (
  set "PREAMBLE=\usepackage[utf8]{inputenc}\usepackage{xcolor}\DeclareUnicodeCharacter{2248}{\ensuremath{\approx}}\DeclareUnicodeCharacter{2013}{--}\DeclareUnicodeCharacter{2014}{---}\DeclareUnicodeCharacter{2026}{\ldots}\renewcommand{\DIFdel}[1]{}\renewcommand{\DIFdelbegin}{}\renewcommand{\DIFdelend}{}\renewcommand{\DIFadd}[1]{\textcolor{blue}{#1}}"
)

echo [1/3] Generating diff TeX (additions only)...
latexdiff -t UNDERLINE --flatten --preamble="%PREAMBLE%" "%OLD%" "%NEW%" > "%OUT%"
if errorlevel 1 (echo [ERROR] latexdiff failed & exit /b 2)

REM Compile the diff twice
set "EXTRA="
if "%USE_SHELL_ESCAPE%"=="1" set "EXTRA=-shell-escape"

echo [2/3] LaTeX compile pass 1...
"%LATEX%" -interaction=nonstopmode -halt-on-error %EXTRA% "%OUTNAME%.tex" || goto :latexerr
echo [3/3] LaTeX compile pass 2...
"%LATEX%" -interaction=nonstopmode -halt-on-error %EXTRA% "%OUTNAME%.tex" || goto :latexerr

echo.
echo ✔ Done. Created "%OUTNAME%.pdf" showing ONLY added text (no red strikeouts).
exit /b 0

:latexerr
echo [ERROR] LaTeX compilation failed. Check "%OUTNAME%.log" for details.
exit /b 3
